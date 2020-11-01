package com.jcmd.core.impl.executors;

import com.jcmd.core.Executable;

import java.io.IOException;
import java.io.InputStream;

public class FileExecutor extends AbstractExecutor {
    private FileExecutor(ProcessBuilder builder) {
        super(builder);
    }

    public static FileExecutor create(ProcessBuilder builder) {
        return new FileExecutor(builder);
    }

    @Override
    public InputStream execute(Executable executable) throws IOException {
        return getProcessBuilder().command("/bin/bash", "-c", "bash " + executable.getExecutable())
                .start().getInputStream();
    }
}
