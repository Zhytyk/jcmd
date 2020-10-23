package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.args.EmptyUnixParameter;
import com.jcmd.core.impl.responses.LsResponse;

public class Ls implements Command {
    public static final String LS = "ls";

    private Parameter parameter;


    private Ls(Parameter parameter) {
        this.parameter = parameter;
    }

    public static Ls create() {
        return new Ls(EmptyUnixParameter.create());
    }

    public static Ls create(Parameter parameter) {
        return new Ls(parameter);
    }

    @Override
    public String getCommand() {
        return LS + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return LsResponse.create(this, output);
    }
}
