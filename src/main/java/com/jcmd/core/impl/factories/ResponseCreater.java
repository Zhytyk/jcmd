package com.jcmd.core.impl.factories;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;

public class ResponseCreater {
    private static ResponseCreater responseCreater = new ResponseCreater();

    public static ResponseCreater getInstance() {
        return responseCreater;
    }

    public CmdResponse create(Executable executable, String output) {
        return executable.createResponse(output);
    }
}
