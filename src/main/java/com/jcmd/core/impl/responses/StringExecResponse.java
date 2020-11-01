package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.utils.StringExecutable;

public class StringExecResponse extends AbstractResponse {

    public static StringExecResponse create(StringExecutable stringExec, String output) {
        return new StringExecResponse(stringExec, output);
    }

    private StringExecResponse(StringExecutable stringExec, String output) {
        super(output, stringExec);
    }
}
