package com.jcmd.core.impl;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;

public class Pwd implements Command {
    private static final String PWD = "pwd";

    public static Pwd create() {
        return new Pwd();
    }

    private Pwd() {

    }

    @Override
    public String getCommand() {
        return PWD;
    }

    @Override
    public CmdResponse createResponse(String output) {
        return PwdResponse.create(this, output);
    }
}
