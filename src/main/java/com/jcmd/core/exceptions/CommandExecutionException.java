package com.jcmd.core.exceptions;

public class CommandExecutionException extends RuntimeException {

    public CommandExecutionException() {
    }

    public CommandExecutionException(Throwable cause) {
        super(cause);
    }
}
