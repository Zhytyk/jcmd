package com.jcmd.core.impl;

import com.google.common.collect.Lists;
import com.jcmd.core.CmdResponse;
import com.jcmd.core.Cmder;
import com.jcmd.core.Executable;
import com.jcmd.core.Constants;
import com.jcmd.core.exceptions.CommandExecutionException;
import com.jcmd.core.exceptions.NoCommandToExecuteException;
import com.jcmd.core.impl.cmds.CompositeExecutable;
import com.jcmd.core.impl.executors.CommandExecutor;
import com.jcmd.core.impl.executors.Executor;
import com.jcmd.core.impl.executors.ProxyExecutor;
import com.jcmd.core.impl.factories.ResponseCreater;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class CmderPipeline implements Cmder {
    private Executor executor;
    private ResponseCreater responseCreater = ResponseCreater.getInstance();
    private List<Executable> executables = Lists.newArrayList();

    CmderPipeline(File file) {
        executor = ProxyExecutor.create(file);
    }

    void addCommand(Executable executable) {
        this.executables.add(executable);
    }

    @Override
    public List<CmdResponse> exec() {
        List<CmdResponse> output = Lists.newLinkedList();

        if (executables.isEmpty()) {
            throw new NoCommandToExecuteException();
        }

        try {
            for (Executable executable : executables) {
                output.add(executeCommand(executable));
            }
        } catch (IOException e) {
            throw new CommandExecutionException(e);
        }

        return output;
    }

    @Override
    public String directory() {
        return executor.directory();
    }

    @Override
    public String home() {
        return System.getProperty("user.home");
    }

    @Override
    public Cmder compose() {
        CompositeExecutable compositeCmd =
                CompositeExecutable.create(Lists.newArrayList(this.executables));
        this.executables.clear();
        addCommand(compositeCmd);
        return this;
    }

    private CmdResponse executeCommand(Executable executable) throws IOException {
        String output = execute(executable);
        return responseCreater.create(executable, output);
    }

    private String execute(Executable executable) throws IOException {
        return String.join(Constants.NL,
                IOUtils.readLines(executeWithProcessBuilder(executable)));
    }

    private InputStream executeWithProcessBuilder(Executable executable)
            throws IOException {
        return executor.execute(executable);
    }
}
