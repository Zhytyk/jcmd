package com.jcmd.core.exception;

public class CommandExecutionException extends RuntimeException {

    public CommandExecutionException() {
    }

    public CommandExecutionException(Throwable cause) {
        super(cause);
    }
}
