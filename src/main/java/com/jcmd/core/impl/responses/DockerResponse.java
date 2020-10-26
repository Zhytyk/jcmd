package com.jcmd.core.impl.responses;

import com.jcmd.core.impl.cmds.Docker;

public class DockerResponse extends AbstractResponse {
    public static DockerResponse create(Docker docker, String output) {
        return new DockerResponse(docker, output);
    }

    private DockerResponse(Docker docker, String output) {
        super(output, docker);
    }
}
