package com.jcmd.core.impl.executors;

import com.jcmd.core.Executable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ProxyExecutor implements Executor {
    private ProcessBuilder processBuilder = new ProcessBuilder();
    private File file;

    private ProxyExecutor(File file) {
        this.file = file;
    }

    public static ProxyExecutor create(File file) {
        return new ProxyExecutor(file);
    }

    @Override
    public InputStream execute(Executable executable) throws IOException {
        Executor executor = executable.getExecutor(processBuilder);
        executor.directory(file);
        return executor.execute(executable);
    }

    @Override
    public String directory() {
        return processBuilder.directory().getAbsolutePath();
    }

    @Override
    public ProcessBuilder directory(File file) {
        return processBuilder.directory(file);
    }
}
