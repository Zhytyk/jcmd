package com.jcmd.core.impl.cmds;

import com.google.common.collect.Lists;
import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.args.EmptyUnixParameter;
import com.jcmd.core.impl.responses.DockerResponse;

import java.util.List;

public class Docker implements Command {
    private static final String DOCKER = "docker";

    private List<Parameter> parameters;


    private Docker(Parameter... parameter) {
        this.parameters = Lists.newArrayList(parameter);
    }

    public static Docker create() {
        return new Docker(EmptyUnixParameter.create());
    }

    public static Docker create(Parameter... parameter) {
        return new Docker(parameter);
    }

    @Override
    public String getCommand() {
        StringBuilder command = new StringBuilder(DOCKER);

        for (Parameter parameter : parameters) {
            command.append(Constants.SPACE).append(parameter.convertToString());
        }

        return command.toString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return DockerResponse.create(this, output);
    }
}

