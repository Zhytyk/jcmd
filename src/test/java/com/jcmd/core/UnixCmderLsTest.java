package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderLsTest {

    @Test
    public void simpleLs() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses = unixCmder.cd(UnixParameter.create("~")).ls().compose().exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }
}
