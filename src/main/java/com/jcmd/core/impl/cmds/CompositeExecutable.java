package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Executable;
import com.jcmd.core.Constants;
import com.jcmd.core.impl.responses.CompositeCmdResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CompositeExecutable implements Executable {
    private List<Executable> executables;

    private CompositeExecutable(List<Executable> executables) {
        this.executables = executables;
    }

    public static CompositeExecutable create(List<Executable> executables) {
        return new CompositeExecutable(executables);
    }

    @Override
    public String getExecutable() {
        return executables.stream()
                .map(Executable::getExecutable)
                .reduce((c1, c2) -> c1 + Constants.SEMICOLON + c2)
                .orElse(StringUtils.EMPTY);
    }

    @Override
    public CmdResponse createResponse(String output) {
        return CompositeCmdResponse.create(this, output);
    }
}
