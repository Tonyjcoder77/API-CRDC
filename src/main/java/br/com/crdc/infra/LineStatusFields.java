package br.com.crdc.infra;

public class LineStatusFields {

    private boolean flagTipoError;
    private boolean flagValorError;
    private boolean flagContaOrigemError;
    private boolean flagContaDestinoError;

    public LineStatusFields(boolean flagTipoError, boolean flagValorError, boolean flagContaOrigemError, boolean flagContaDestinoError) {
        this.flagTipoError = flagTipoError;
        this.flagValorError = flagValorError;
        this.flagContaOrigemError = flagContaOrigemError;
        this.flagContaDestinoError = flagContaDestinoError;
    }

    public boolean isFlagTipoError() {
        return flagTipoError;
    }

    public void setFlagTipoError(boolean flagTipoError) {
        this.flagTipoError = flagTipoError;
    }

    public boolean isFlagValorError() {
        return flagValorError;
    }

    public void setFlagValorError(boolean flagValorError) {
        this.flagValorError = flagValorError;
    }

    public boolean isFlagContaOrigemError() {
        return flagContaOrigemError;
    }

    public void setFlagContaOrigemError(boolean flagContaOrigemError) {
        this.flagContaOrigemError = flagContaOrigemError;
    }

    public boolean isFlagContaDestinoError() {
        return flagContaDestinoError;
    }

    public void setFlagContaDestinoError(boolean flagContaDestinoError) {
        this.flagContaDestinoError = flagContaDestinoError;
    }
}
