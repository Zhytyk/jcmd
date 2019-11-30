package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderPwdTest {

    @Test
    public void simplePwd() {
        UnixCmder unixCmder = new UnixCmderPipeline();
        List<CmdResponse> responses = unixCmder.pwd().exec();

        Assert.assertEquals(1, responses.size());
        Assert.assertEquals("/Users/pavel/IdeaProjects/jcmd", responses.get(0).getOutput());
    }

}
