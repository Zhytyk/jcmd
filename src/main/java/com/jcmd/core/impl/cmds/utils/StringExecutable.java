package com.jcmd.core.impl.cmds.utils;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;
import com.jcmd.core.impl.responses.StringExecResponse;

public class StringExecutable implements Executable {
    private String executable;

    private StringExecutable(String executable) {
        this.executable = executable;
    }
    
    public static StringExecutable create(String executable) {
        return new StringExecutable(executable);
    }

    @Override
    public String getExecutable() {
        return executable;
    }

    @Override
    public CmdResponse createResponse(String output) {
        return StringExecResponse.create(this, output);
    }
}
