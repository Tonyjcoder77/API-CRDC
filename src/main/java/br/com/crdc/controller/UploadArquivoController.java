package br.com.crdc.controller;

import br.com.crdc.controller.dto.*;
import br.com.crdc.infra.FileStatusFields;
import br.com.crdc.modelo.FileData;
import br.com.crdc.modelo.Transacao;
import br.com.crdc.services.FileServices;
import br.com.crdc.services.TrataErrorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/Upload")
public class UploadArquivoController {
	@Autowired
	private FileServices fileService;

	@Autowired
	private TrataErrorServices trataErrorServices;
	private final String pathArquivos;
	public UploadArquivoController(@Value("${app.path.arquivos}") String pathArquivos){
		this.pathArquivos = pathArquivos;
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<JsonRetDto> processFile(@RequestParam("file") MultipartFile file) throws IOException {
		String resp = fileService.uploadFile(file, this.pathArquivos);
		FileData filedata = fileService.processLocalFile(resp);

		FileStatusFields fileStatusFields = fileService.verificaCamposInconsistentes(filedata.getPreTransacoes());
		if(fileStatusFields.isFlagFileError()) {

			List<LinhaDto> lines = trataErrorServices.verificaErros(fileStatusFields);

			LinhaErro jsonLinha = new LinhaErro(lines);
			JsonRetErro1 err1 = new JsonRetErro1("error",
					"Erro nos registros",
					jsonLinha);
			return new ResponseEntity(err1, HttpStatus.BAD_REQUEST);
		}

		List<Transacao> transacoes = fileService.obtemEntidades(filedata.getPreTransacoes());
		fileService.loadDB(filedata.getEmpresa(), transacoes);

		List<TransacaoDto> trs = TransacaoDto.converter(transacoes);
		JsonRetTrn jsonRetTrn = new JsonRetTrn(trs);
		JsonRetDto jsonRetDto = new JsonRetDto("success",
				                          "Arquivo CNAB enviado e processado com sucesso.",
				                           jsonRetTrn);
		return new ResponseEntity(jsonRetDto, HttpStatus.OK);

		//return ResponseEntity.ok(TransacaoDto.converter(filedata.getTransacoes()));
	}

}
