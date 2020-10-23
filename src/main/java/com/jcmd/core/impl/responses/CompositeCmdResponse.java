package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.CompositeCommand;

public class CompositeCmdResponse extends AbstractResponse {
    public static CompositeCmdResponse create(CompositeCommand compositeCommand,
                                              String output) {
        return new CompositeCmdResponse(compositeCommand, output);
    }

    private CompositeCmdResponse(CompositeCommand compositeCommand,
                                 String output) {
        super(output, compositeCommand);
    }
}
