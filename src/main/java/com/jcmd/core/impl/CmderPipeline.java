package com.jcmd.core.impl;

import com.google.common.collect.Lists;
import com.jcmd.core.CmdResponse;
import com.jcmd.core.Cmder;
import com.jcmd.core.Command;
import com.jcmd.core.exception.CommandExecutionException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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

        try {
            for (Command command : commands) {
                output.add(
                        responseCreater.create(
                                command,
                                String.join(StringUtils.EMPTY, (IOUtils.readLines(
                                        processBuilder.command("/bin/bash", "-c", command.getCommand())
                                                .start().getInputStream()
                                        ))
                                )
                        )
                );
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
}
