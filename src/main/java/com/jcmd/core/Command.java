package com.jcmd.core;

public interface Command {
    String getCommand();
    CmdResponse createResponse(String output);
}
