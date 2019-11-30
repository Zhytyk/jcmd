package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderPwdTest {

    @Test
    public void simplePwd() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses = unixCmder.pwd().exec();

        Assert.assertEquals(1, responses.size());
        Assert.assertEquals(unixCmder.directory(), responses.get(0).getOutput());
    }

    @Test
    public void multiplePwds() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses = unixCmder.pwd().pwd().pwd().exec();

        Assert.assertEquals(3, responses.size());
        responses.forEach(response ->
            Assert.assertEquals(unixCmder.directory(), response.getOutput())
        );

    }

}
