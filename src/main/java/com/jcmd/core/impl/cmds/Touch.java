package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.responses.NoResponse;

public class Touch implements Executable {
    private static final String TOUCH = "touch";

    private Parameter parameter;

    private Touch(Parameter parameter) {
        this.parameter = parameter;
    }

    public static Touch create(Parameter parameter) {
        return new Touch(parameter);
    }

    @Override
    public String getExecutable() {
        return TOUCH + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
