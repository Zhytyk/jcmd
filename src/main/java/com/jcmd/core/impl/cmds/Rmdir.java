package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.responses.NoResponse;

public class Rmdir implements Command {
    private static final String RM_DIR = "rmdir";

    private Parameter parameter;

    private Rmdir(Parameter parameter) {
        this.parameter = parameter;
    }

    public static Rmdir create(Parameter parameter) {
        return new Rmdir(parameter);
    }

    @Override
    public String getCommand() {
        return RM_DIR + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
