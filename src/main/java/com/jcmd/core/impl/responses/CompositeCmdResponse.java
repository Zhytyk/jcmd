package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.CompositeExecutable;

public class CompositeCmdResponse extends AbstractResponse {
    public static CompositeCmdResponse create(CompositeExecutable compositeCommand,
                                              String output) {
        return new CompositeCmdResponse(compositeCommand, output);
    }

    private CompositeCmdResponse(CompositeExecutable compositeCommand,
                                 String output) {
        super(output, compositeCommand);
    }
}
