package com.jcmd.core.impl.cmds;

import com.jcmd.core.*;
import com.jcmd.core.impl.responses.NoResponse;

public class Cd implements Command, NoResponseCommand {
    private static final String CD = "cd";

    private Parameter parameter;

    public static Cd create(Parameter parameter) {
        return new Cd(parameter);
    }

    private Cd(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getCommand() {
        return CD + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
