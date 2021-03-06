package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.responses.NoResponse;

public class Rm implements Executable {
    private static final String RM = "rm";

    private Parameter parameter;

    private Rm(Parameter parameter) {
        this.parameter = parameter;
    }

    public static Rm create(Parameter parameter) {
        return new Rm(parameter);
    }

    @Override
    public String getExecutable() {
        return RM + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
