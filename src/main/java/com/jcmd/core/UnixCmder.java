package com.jcmd.core;

public interface UnixCmder extends Cmder {
    UnixCmder pwd();
    UnixCmder cd();
    UnixCmder ls(String... args);
    UnixCmder mkdir(String... args);
    UnixCmder rmdir();
    UnixCmder touch();
}
