package com.yang.exception;

public class InitException extends Throwable {

    private static final long serialVersionUID = -581984046035303044L;

    public InitException() {
        super();
    }

    public InitException(String message, Throwable cause) {
        super(message, cause);
    }

    public InitException(String message) {
        super(message);
    }

    public InitException(Throwable cause) {
        super(cause);
    }

}
