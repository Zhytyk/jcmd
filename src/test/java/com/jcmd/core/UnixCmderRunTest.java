package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderRunTest {

    @Test
    public void simpleRun() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.run("docker -v").exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }
}
