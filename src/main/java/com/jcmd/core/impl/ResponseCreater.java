package com.jcmd.core.impl;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;

public class ResponseCreater {
    private static ResponseCreater responseCreater = new ResponseCreater();

    public static ResponseCreater getInstance() {
        return responseCreater;
    }

    public CmdResponse create(Command command, String output) {
        return command.createResponse(output);
    }
}
