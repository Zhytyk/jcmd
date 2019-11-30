package com.jcmd.core.impl;

import com.jcmd.core.UnixCmder;

public class UnixCmderPipeline extends CmderPipeline implements UnixCmder {

    @Override
    public UnixCmder pwd() {
        addCommand(Pwd.create());
        return this;
    }

    @Override
    public UnixCmder cd() {
        return this;
    }

    @Override
    public UnixCmder ls(String... args) {
        return this;
    }

    @Override
    public UnixCmder mkdir(String... args) {
        return this;
    }

    @Override
    public UnixCmder rmdir() {
        return this;
    }

    @Override
    public UnixCmder touch() {
        return this;
    }
}
