package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.utils.FileExecutable;

public class FileExecResponse extends AbstractResponse {

    public static FileExecResponse create(FileExecutable fileExec, String output) {
        return new FileExecResponse(fileExec, output);
    }

    private FileExecResponse(FileExecutable fileExec, String output) {
        super(output, fileExec);
    }
}
