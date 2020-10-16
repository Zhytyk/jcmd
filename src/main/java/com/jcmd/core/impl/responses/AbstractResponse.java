package com.jcmd.core.impl.responses;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;

public abstract class AbstractResponse implements CmdResponse {
    private String output;
    private Command command;

    public AbstractResponse(String output, Command command) {
        this.output = output;
        this.command = command;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public String getOutput() {
        return output;
    }
}
