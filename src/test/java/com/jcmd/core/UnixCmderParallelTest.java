package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.parallel.ParallelConfiguration;
import com.jcmd.core.impl.parallel.ParallelTaskExecutorResult;
import com.jcmd.core.impl.parallel.UnixCmderExecutor;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class UnixCmderParallelTest {

    @Test
    public void simpleParallel() {
        ParallelConfiguration config = ParallelConfiguration.create(2);
        CmderExecutor executor = UnixCmderExecutor.create(config);

        List<ParallelTaskExecutorResult> result = executor.parallel(
                UnixCmderPipeline.create().ls().pwd(),
                UnixCmderPipeline.create().pwd().ls()
        ).join(
                UnixCmderPipeline.create(Paths.get(System.getProperty("user.home")))
        ).exec();


        ParallelTaskExecutorResult parallelTaskExecutorResult = result.get(0);

        Assert.assertEquals(result.size(), 1);
        Assert.assertEquals(parallelTaskExecutorResult.getParallelUnixCmderResults().size(), 2);
        Assert.assertEquals(parallelTaskExecutorResult.getJoinUnixCmderResults().size(), 1);
    }

}
