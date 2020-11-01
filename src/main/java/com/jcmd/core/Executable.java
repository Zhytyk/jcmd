package com.jcmd.core;

import com.jcmd.core.impl.executors.CommandExecutor;
import com.jcmd.core.impl.executors.Executor;

public interface Executable {
    String getExecutable();
    CmdResponse createResponse(String output);
    default Executor getExecutor(ProcessBuilder builder) {
        return CommandExecutor.create(builder);
    }
}
