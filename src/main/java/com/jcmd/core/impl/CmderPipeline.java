package com.jcmd.core.impl;

import com.google.common.collect.Lists;
import com.jcmd.core.*;
import com.jcmd.core.exceptions.CommandExecutionException;
import com.jcmd.core.exceptions.NoCommandToExecuteException;
import com.jcmd.core.impl.cmds.Cd;
import com.jcmd.core.impl.factories.ResponseCreater;
import com.jcmd.core.impl.responses.NoResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        if (commands.isEmpty()) {
            throw new NoCommandToExecuteException();
        }

        try {
            return executeCommand();
        } catch (IOException e) {
            throw new CommandExecutionException(e);
        }
    }

    @Override
    public String directory() {
        return processBuilder.directory().getAbsolutePath();
    }

    @Override
    public String home() {
        return System.getProperty("user.home");
    }

    private List<CmdResponse> executeCommand() throws IOException {
        Iterator<String> outputIterator = execute().iterator();
        return commands.stream()
                .map(c -> responseCreater.create(c,
                        c instanceof NoResponseCommand
                                ? StringUtils.EMPTY : outputIterator.next()))
                .collect(Collectors.toList());
    }

    private List<String> execute() throws IOException {
        return IOUtils.readLines(executeWithProcessBuilder());
    }

    private InputStream executeWithProcessBuilder() throws IOException {
        List<String> commandList = Lists.newLinkedList();
        commandList.add("/bin/bash");
        commandList.add("-c");

        StringBuilder commandStr = new StringBuilder();
        for (Command command : commands) {
            commandStr.append(command.getCommand())
                    .append(Constants.SPACE)
                    .append(Constants.SEMICOLON)
                    .append(Constants.SPACE);
        }

        commandList.add(commandStr.toString());

        return processBuilder.command(commandList)
                .start().getInputStream();
    }
}
