package com.jcmd.core.impl.responses;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;

public abstract class AbstractResponse implements CmdResponse {
    private String output;
    private Executable executable;

    public AbstractResponse(String output, Executable executable) {
        this.output = output;
        this.executable = executable;
    }

    @Override
    public Executable getExecutable() {
        return executable;
    }

    @Override
    public String getOutput() {
        return output;
    }
}
