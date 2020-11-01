package com.jcmd.core;

public interface UnixCmder extends Cmder {
    UnixCmder pwd();
    UnixCmder cd(Parameter parameter);
    UnixCmder ls();
    UnixCmder ls(Parameter parameter);
    UnixCmder mkdir(Parameter parameter);
    UnixCmder rmdir(Parameter parameter);
    UnixCmder touch(Parameter parameter);
    UnixCmder rm(Parameter parameter);
    UnixCmder sleep(Parameter parameter);
    UnixCmder docker();
    UnixCmder docker(Parameter... parameters);
    UnixCmder run(String executable);
    UnixCmder runFile(String path);
    UnixCmder runFile(String path, Parameter parameter);
}
