package br.com.crdc.services;

import br.com.crdc.infra.FileStatusFields;
import br.com.crdc.infra.LineStatusFields;
import br.com.crdc.infra.exception.FormatoInvalidoException;
import br.com.crdc.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class FileServices {

    @Autowired
    LinhaServices linhaServices;
    public String uploadFile(MultipartFile file, String pathArquivos) {

        System.out.println("recebendo o arquivo: " + file.getOriginalFilename());
        String caminho = pathArquivos
                + UUID.randomUUID()
                + "."
                + extrairExtensao(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), Path.of(caminho), StandardCopyOption.REPLACE_EXISTING);
            return caminho;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo! ", e);
        }
    }
    private String extrairExtensao(String nomeArquivo) {
         int i = nomeArquivo.lastIndexOf(".");
         return nomeArquivo.substring(i + 1);
    }

    public FileData processLocalFile(String nomeArquivo) throws IOException {

        FileInputStream stream = new FileInputStream(nomeArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        String linha = br.readLine();
        Empresa empresa = null;
        PreTransacao preTransacao;
        ProcRegistros procRegistros = new ProcRegistros();
        ProcessaReg processaReg01 = new ProcessaReg01();
        ProcessaReg processaReg02 = new ProcessaReg02();
        List<PreTransacao> preTransacoes = new ArrayList<>();
        while (linha != null) {
            if (linha.length() != 80) {
                throw new FormatoInvalidoException("Erro ao processar o arquivo CNAB. Certifique-se de que o arquivo esteja no formato posicional correto");
            }
            if (linha.substring(0, 3).equalsIgnoreCase("001")) {
                empresa = (Empresa) procRegistros.processar(linha, processaReg01);
            } else {
                if (linha.substring(0, 3).equalsIgnoreCase("002")) {
                    preTransacao = (PreTransacao) procRegistros.processar(linha, processaReg02);
                    preTransacoes.add(preTransacao);
                }
            }
            linha = br.readLine();
        }
        FileData fida = new FileData(empresa, preTransacoes);
        return fida;
    }

    public FileStatusFields verificaCamposInconsistentes(List<PreTransacao> preTransacoes){
        List<LineStatusFields> linhasDeStatusDosCampos = new ArrayList<>();

        Boolean flagFileError = false;
        for(PreTransacao preTr: preTransacoes){

            LineStatusFields lneStatus = new LineStatusFields(false,false, false,false);

            lneStatus.setFlagTipoError(linhaServices.checkTipoError(preTr.getTipo()));
            lneStatus.setFlagValorError(linhaServices.checkValorError(preTr.getValor()));
            lneStatus.setFlagContaOrigemError(linhaServices.checkContaOrigemError(preTr.getContaOrigem()));
            lneStatus.setFlagContaDestinoError(linhaServices.checkContaDestinoError(preTr.getContaDestino()));
            if(lneStatus.isFlagTipoError() || lneStatus.isFlagValorError() ||
               lneStatus.isFlagContaOrigemError() || lneStatus.isFlagContaDestinoError()) flagFileError = true;
            linhasDeStatusDosCampos.add(lneStatus);
        }
        return new FileStatusFields(flagFileError, linhasDeStatusDosCampos);
    }
    public List<Transacao> obtemEntidades(List<PreTransacao> preTransacoes) throws IOException {

        List<Transacao> transacoes = PreTransacao.converter(preTransacoes);

        return transacoes;
    }
    public void loadDB(Empresa empresa, List<Transacao> transacoes) throws IOException {

        RestTemplate restTemplate = new RestTemplateBuilder().build();
        HttpEntity<Empresa> entityEp = new HttpEntity(empresa);
        String campo = restTemplate.exchange("http://localhost:8080/Empresas",
                HttpMethod.POST,
                entityEp,
                String.class).getBody();
        Long maxValue = restTemplate.exchange("http://localhost:8080/Empresas/Max",
                HttpMethod.GET,
                entityEp,
                Long.class).getBody();
        Map<String, Long> parms = new HashMap<String, Long>();
        parms.put("id", maxValue);

        for(Transacao trs: transacoes) {
            Transacao transacao = new Transacao();
            transacao.setTipo(trs.getTipo());
            transacao.setValor(trs.getValor());
            transacao.setContaOrigem(trs.getContaOrigem());
            transacao.setContaDestino(trs.getContaDestino());

            HttpEntity<Transacao> entityTr = new HttpEntity(transacao);
            String campos = restTemplate.exchange("http://localhost:8080/Transacoes/Cadastrar/{id}",
                    HttpMethod.POST,
                    entityTr,
                    String.class, parms).getBody();
        }
    }
}
