package com.jcmd.core.impl;

import com.google.common.collect.Lists;
import com.jcmd.core.CmdResponse;
import com.jcmd.core.Cmder;
import com.jcmd.core.Command;
import com.jcmd.core.exceptions.CommandExecutionException;
import com.jcmd.core.exceptions.NoCommandToExecuteException;
import com.jcmd.core.impl.factories.ResponseCreater;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class CmderPipeline implements Cmder {
    private ProcessBuilder processBuilder = new ProcessBuilder();
    private ResponseCreater responseCreater = ResponseCreater.getInstance();
    private List<Command> commands = Lists.newArrayList();

    CmderPipeline(File file) {
        processBuilder.directory(file);
    }

    void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public List<CmdResponse> exec() {
        List<CmdResponse> output = Lists.newLinkedList();

        if (commands.isEmpty()) {
            throw new NoCommandToExecuteException();
        }

        try {
            for (Command command : commands) {
                output.add(executeCommand(command));
            }
        } catch (IOException e) {
            throw new CommandExecutionException(e);
        }

        return output;
    }

    @Override
    public String directory() {
        return processBuilder.directory().getAbsolutePath();
    }

    private CmdResponse executeCommand(Command command) throws IOException {
        String output = execute(command);
        return responseCreater.create(command, output);
    }

    private String execute(Command command) throws IOException {
        return String.join(StringUtils.EMPTY,
                IOUtils.readLines(executeWithProcessBuilder(command)));
    }

    private InputStream executeWithProcessBuilder(Command command) throws IOException {
        return processBuilder.command("/bin/bash", "-c", command.getCommand())
                .start().getInputStream();
    }
}
