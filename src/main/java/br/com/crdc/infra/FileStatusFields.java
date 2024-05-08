package br.com.crdc.infra;

import java.util.List;

public class FileStatusFields {

    private boolean flagFileError;
    private List<LineStatusFields> lineStatusFieldsList;

    public FileStatusFields(boolean flagFileError, List<LineStatusFields> lineStatusFieldsList) {
        this.flagFileError = flagFileError;
        this.lineStatusFieldsList = lineStatusFieldsList;
    }

    public boolean isFlagFileError() {
        return flagFileError;
    }

    public List<LineStatusFields> getLineStatusFieldsList() {
        return lineStatusFieldsList;
    }
}
