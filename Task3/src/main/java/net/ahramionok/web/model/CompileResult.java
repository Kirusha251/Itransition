package net.ahramionok.web.model;

/**
 * Created by Kirill on 06.12.2016.
 */
public class CompileResult {
    private String result;
    private boolean isCompiled;
    private String errorMessage;

    public CompileResult() {
    }

    public CompileResult(String result, boolean isCompiled, String errorMessage) {
        this.result = result;
        this.isCompiled = isCompiled;
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isCompiled() {
        return isCompiled;
    }

    public void setCompiled(boolean compiled) {
        isCompiled = compiled;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
