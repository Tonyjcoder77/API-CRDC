package br.com.crdc.services;

import br.com.crdc.modelo.RegTipo;
import org.springframework.stereotype.Service;

@Service
public class LinhaServices {

    public boolean checkTipoError(String tipo) {

        System.out.println("tipo ===>" + tipo);
        if (tipo == null) {
            return true;
        }
        try {
            RegTipo.valueOf(tipo);
            return false;
        }catch (IllegalArgumentException e) {
            return true;
        }
    }

    public boolean checkValorError(String valor) {
        if (valor == null) {
            return true;
        }
        try {
            double d = Double.parseDouble(valor);
        } catch (NumberFormatException nfe) {
            return true;
        }

        if(Double.parseDouble(valor) == Double.valueOf(0)){
            return true;
        }

        return false;
    }
    public boolean checkContaOrigemError(String contaOrigem) {

        if (contaOrigem == null) {
            return true;
        }
        try {
            Integer I = Integer.parseInt(contaOrigem);
        } catch (NumberFormatException nfe) {
            return true;
        }

        if(Integer.parseInt(contaOrigem) == Integer.valueOf(0)){
            return true;
        }

        return false;
    }
    public boolean checkContaDestinoError(String contaDestino) {

        if (contaDestino == null) {
            return true;
        }
        try {
            Integer I = Integer.parseInt(contaDestino);
        } catch (NumberFormatException nfe) {
            return true;
        }

        if(Integer.parseInt(contaDestino) == Integer.valueOf(0)){
            return true;
        }

        return false;
    }
}
