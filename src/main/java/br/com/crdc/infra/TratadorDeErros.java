package br.com.crdc.infra;

import br.com.crdc.controller.dto.JsonRetErro2;
import br.com.crdc.infra.exception.FormatoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(FormatoInvalidoException.class)
    @ResponseBody
    public ResponseEntity<JsonRetErro2> tratarErro400(FormatoInvalidoException ex) {
        JsonRetErro2 err2 = new JsonRetErro2( "error", ex.getMessage());
        return new ResponseEntity(err2, HttpStatus.BAD_REQUEST);
    }


}
