package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class UnixCmderLsTest {

    @Test
    public void simpleLs() {
        UnixCmder unixCmder = UnixCmderPipeline.create(
                Paths.get(System.getProperty("user.home")));
        List<CmdResponse> responses = unixCmder.ls().exec();

        Assert.assertEquals(1, responses.size());
    }
}
