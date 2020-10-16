package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.responses.CdResponse;

public class Cd implements Command {
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
        return CdResponse.create(this, output);
    }
}
