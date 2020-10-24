package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderTouchTest {
    private static final String PAVLO = "Pavlo-file";

    @Test
    public void simpleTouch() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses = unixCmder.touch(UnixParameter.create(PAVLO))
                .ls().exec();

        Assert.assertEquals(2, responses.size());
        Assert.assertThat(responses.get(1).getOutput(),
                CoreMatchers.containsString(PAVLO));
    }
}
