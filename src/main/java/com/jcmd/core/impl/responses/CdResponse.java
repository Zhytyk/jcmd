package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.Cd;

public class CdResponse extends AbstractResponse {

    public static CdResponse create(Cd cd, String output) {
        return new CdResponse(cd, output);
    }

    private CdResponse(Cd cd, String output) {
        super(output, cd);
    }


}
