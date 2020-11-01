package com.jcmd.core.impl.cmds.utils;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Constants;
import com.jcmd.core.Executable;
import com.jcmd.core.Parameter;
import com.jcmd.core.impl.args.EmptyUnixParameter;
import com.jcmd.core.impl.executors.Executor;
import com.jcmd.core.impl.executors.FileExecutor;
import com.jcmd.core.impl.responses.FileExecResponse;

public class FileExecutable implements Executable {
    private String executable;
    private Parameter parameter;

    private FileExecutable(String path, Parameter parameter) {
        this.executable = path;
        this.parameter = parameter;
    }

    public static FileExecutable create(String executable) {
        return new FileExecutable(executable, EmptyUnixParameter.create());
    }

    public static FileExecutable create(String executable, Parameter parameter) {
        return new FileExecutable(executable, parameter);
    }

    @Override
    public String getExecutable() {
        return executable + Constants.SPACE + parameter.convertToString();
    }

    @Override
    public CmdResponse createResponse(String output) {
        return FileExecResponse.create(this, output);
    }

    @Override
    public Executor getExecutor(ProcessBuilder builder) {
        return FileExecutor.create(builder);
    }
}
