package com.jcmd.core.impl.cmds;

import com.jcmd.core.*;
import com.jcmd.core.impl.responses.NoResponse;

public class Sleep implements Executable, NoResponseCommand {
    private static final String SLEEP = "sleep";

    private Parameter parameter;

    public static Sleep create(Parameter parameter) {
        return new Sleep(parameter);
    }

    private Sleep(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getExecutable() {
        return SLEEP + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
