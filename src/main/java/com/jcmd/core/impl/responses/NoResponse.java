package com.jcmd.core.impl.responses;

import com.jcmd.core.Executable;

public class NoResponse extends AbstractResponse {

    public static NoResponse create(Executable cmd, String output) {
        return new NoResponse(cmd, output);
    }

    private NoResponse(Executable cmd, String output) {
        super(output, cmd);
    }

    @Override
    public String getOutput() {
        throw new UnsupportedOperationException("output is not supported in NoResponse");
    }
}
