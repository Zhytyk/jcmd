package com.jcmd.core;

import com.jcmd.core.exceptions.NoCommandToExecuteException;
import com.jcmd.core.impl.UnixCmderPipeline;
import org.junit.Assert;
import org.junit.Test;

public class UnixCmderTest {

    @Test
    public void simpleCmder() {
        UnixCmderPipeline cmder = UnixCmderPipeline.create();

        Assert.assertNotNull(cmder);
        Assert.assertEquals(cmder.directory(), System.getProperty("user.dir"));
    }

    @Test(expected = NoCommandToExecuteException.class)
    public void emptyCmderExec()  {
        UnixCmderPipeline cmder = UnixCmderPipeline.create();

        cmder.exec();
    }
}
