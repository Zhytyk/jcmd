package com.jcmd.core.impl.executors;

import com.jcmd.core.Executable;

import java.io.IOException;
import java.io.InputStream;

public class CommandExecutor extends AbstractExecutor {

    private CommandExecutor(ProcessBuilder builder) {
        super(builder);
    }

    public static CommandExecutor create(ProcessBuilder processBuilder) {
        return new CommandExecutor(processBuilder);
    }

    @Override
    public InputStream execute(Executable executable) throws IOException {
        return getProcessBuilder().command("/bin/bash", "-c", executable.getExecutable())
                .start().getInputStream();
    }
}
