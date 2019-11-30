package com.jcmd.core.impl;

import com.jcmd.core.UnixCmder;
import com.jcmd.core.exception.CmderInitializationException;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UnixCmderPipeline extends CmderPipeline implements UnixCmder {

    public static UnixCmderPipeline create() {
        return new UnixCmderPipeline(new File(System.getProperty("user.dir")));
    }

    public static UnixCmderPipeline create(Path path) {
        return new UnixCmderPipeline(path.toFile());
    }

    private UnixCmderPipeline(File file) {
        super(file);
    }

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
