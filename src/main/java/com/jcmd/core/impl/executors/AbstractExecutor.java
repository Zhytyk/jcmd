package com.jcmd.core.impl.executors;

import java.io.File;

public abstract class AbstractExecutor implements Executor {
    private ProcessBuilder processBuilder;

    AbstractExecutor(ProcessBuilder builder) {
        this.processBuilder = builder;
    }

    @Override
    public String directory() {
        return processBuilder.directory().getAbsolutePath();
    }

    @Override
    public ProcessBuilder directory(File file) {
        return processBuilder.directory(file);
    }

    ProcessBuilder getProcessBuilder() {
        return processBuilder;
    }
}
