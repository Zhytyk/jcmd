package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderRmTest {
    private static final String PAVLO = "Pavlo-file";

    @Test
    public void simpleRm() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses = unixCmder.rm(UnixParameter.create(PAVLO))
                .ls().exec();

        Assert.assertEquals(2, responses.size());
        Assert.assertThat(responses.get(1).getOutput(),
                CoreMatchers.not(CoreMatchers.containsString(PAVLO)));
    }
}
