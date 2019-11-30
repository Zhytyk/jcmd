package com.jcmd.core.impl;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;

public class PwdResponse implements CmdResponse {
    private String output;
    private Pwd pwd;

    public static PwdResponse create(Pwd pwd, String output) {
        return new PwdResponse(pwd, output);
    }

    private PwdResponse(Pwd pwd, String output) {
        this.pwd = pwd;
        this.output = output;
    }

    @Override
    public Command getCommand() {
        return pwd;
    }

    @Override
    public String getOutput() {
        return output;
    }
}
