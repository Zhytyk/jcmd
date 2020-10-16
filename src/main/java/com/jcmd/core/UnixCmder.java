package com.jcmd.core;

public interface UnixCmder extends Cmder {
    UnixCmder pwd();
    UnixCmder cd(Parameter parameter);
    UnixCmder ls(Parameter parameter);
    UnixCmder mkdir(Parameter parameter);
    UnixCmder rmdir();
    UnixCmder touch();
}
