package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderCdTest {

    @Test
    public void cdToCurrent() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.cd(UnixParameter.create(".")).pwd().exec();

        Assert.assertEquals(2, responses.size());
        Assert.assertEquals(unixCmder.directory(), responses.get(1).getOutput());
    }

}
