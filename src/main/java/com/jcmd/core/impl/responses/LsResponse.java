package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.Ls;

public class LsResponse extends AbstractResponse {
    public static LsResponse create(Ls ls, String output) {
        return new LsResponse(ls, output);
    }

    private LsResponse(Ls ls, String output) {
        super(output, ls);
    }
}
