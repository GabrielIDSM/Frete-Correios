package br.com.gabrielidsm.correios.Error;

public class CustomErrorType {
    //Atributos
    private String errorMessage;
    //Construtor
    public CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    //Getters e Setters
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
