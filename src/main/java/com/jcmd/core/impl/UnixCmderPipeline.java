package com.jcmd.core.impl;

import com.jcmd.core.Parameter;
import com.jcmd.core.UnixCmder;
import com.jcmd.core.impl.cmds.*;
import com.jcmd.core.impl.cmds.utils.FileExecutable;
import com.jcmd.core.impl.cmds.utils.StringExecutable;

import java.io.File;
import java.nio.file.Path;

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
    public UnixCmder cd(Parameter parameter) {
        addCommand(Cd.create(parameter));
        return this;
    }

    @Override
    public UnixCmder ls() {
        addCommand(Ls.create());
        return this;
    }

    @Override
    public UnixCmder ls(Parameter parameter) {
        addCommand(Ls.create(parameter));
        return this;
    }

    @Override
    public UnixCmder mkdir(Parameter parameter) {
        addCommand(Mkdir.create(parameter));
        return this;
    }

    @Override
    public UnixCmder rmdir(Parameter parameter) {
        addCommand(Rmdir.create(parameter));
        return this;
    }

    @Override
    public UnixCmder touch(Parameter parameter) {
        addCommand(Touch.create(parameter));
        return this;
    }

    @Override
    public UnixCmder rm(Parameter parameter) {
        addCommand(Rm.create(parameter));
        return this;
    }

    @Override
    public UnixCmder sleep(Parameter parameter) {
        addCommand(Sleep.create(parameter));
        return this;
    }

    @Override
    public UnixCmder docker() {
        addCommand(Docker.create());
        return this;
    }

    @Override
    public UnixCmder docker(Parameter... parameters) {
        addCommand(Docker.create(parameters));
        return this;
    }

    @Override
    public UnixCmder run(String executable) {
        addCommand(StringExecutable.create(executable));
        return this;
    }

    @Override
    public UnixCmder runFile(String path) {
        addCommand(FileExecutable.create(path));
        return this;
    }

    @Override
    public UnixCmder runFile(String path, Parameter parameter) {
        addCommand(FileExecutable.create(path, parameter));
        return this;
    }
}
