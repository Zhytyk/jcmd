package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.args.EmptyUnixParameter;
import com.jcmd.core.impl.responses.NoResponse;

public class Mkdir implements Command {
    private static final String MK_DIR = "mkdir";

    private Parameter parameter;

    private Mkdir(Parameter parameter) {
        this.parameter = parameter;
    }

    public static Mkdir create(Parameter parameter) {
        return new Mkdir(parameter);
    }

    @Override
    public String getCommand() {
        return MK_DIR + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return NoResponse.create(this, output);
    }
}
