package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.Pwd;

public class PwdResponse extends AbstractResponse {

    public static PwdResponse create(Pwd pwd, String output) {
        return new PwdResponse(pwd, output);
    }

    private PwdResponse(Pwd pwd, String output) {
        super(output, pwd);
    }
}
