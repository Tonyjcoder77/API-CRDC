package br.com.crdc.services;

import br.com.crdc.controller.dto.LinhaDto;
import br.com.crdc.infra.FileStatusFields;
import br.com.crdc.infra.LineStatusFields;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrataErrorServices {

    public List<LinhaDto> verificaErros(FileStatusFields fileStatusFields){
        List<LinhaDto> lines = new ArrayList<>();
        Integer lineCount = 0;
        for (LineStatusFields stCampos : fileStatusFields.getLineStatusFieldsList()) {
            LinhaDto linhaDto;
            lineCount++;
            if (stCampos.isFlagTipoError()) {
                linhaDto = new LinhaDto(lineCount, "Tipo", "Tipo Invalido");
                lines.add(linhaDto);
            }
            if (stCampos.isFlagValorError()) {
                linhaDto = new LinhaDto(lineCount, "Valor", "Valor Invalido");
                lines.add(linhaDto);
            }
            if (stCampos.isFlagContaOrigemError()) {
                linhaDto = new LinhaDto(lineCount, "Conta Origem", "Conta Origem Invalida");
                lines.add(linhaDto);
            }
            if (stCampos.isFlagContaDestinoError()) {
                linhaDto = new LinhaDto(lineCount, "Conta Destino", "Conta Destino Invalida");
                lines.add(linhaDto);
            }
        }
        return lines;
    }
}
