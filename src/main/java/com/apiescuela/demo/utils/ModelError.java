package com.apiescuela.demo.utils;

public class ModelError {
    private String mensaje;
    private String codeError;

    public ModelError(String mensaje, String codeError) {
        this.mensaje = mensaje;
        this.codeError = codeError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodeError() {
        return codeError;
    }

    public void setCodeError(String codeError) {
        this.codeError = codeError;
    }
}
