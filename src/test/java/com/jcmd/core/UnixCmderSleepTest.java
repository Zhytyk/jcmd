package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderSleepTest {

    @Test
    public void simpleSleep() {
        UnixCmder unixCmder = UnixCmderPipeline.create();

        long start = System.nanoTime();
        List<CmdResponse> responses =
                unixCmder.sleep(UnixParameter.create("2")).exec();
        long end = System.nanoTime();

        Assert.assertEquals(1, responses.size());
        Assert.assertEquals((end - start) / 1000000000, 2);
    }
}
