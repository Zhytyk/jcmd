package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class UnixCmderDockerTest {

    @Test
    public void simpleDocker() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.docker().exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }

    @Test
    public void dockerRun() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.docker(
                        UnixParameter.create("run"),
                        UnixParameter.createParamsAndOpts(
                                Collections.singletonList("simpleApp"),
                                Collections.singletonList("-name")),
                        UnixParameter.createOpts("d", "p"),
                        UnixParameter.create("80:80", "docker/getting-started")
                ).exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }

    @Test
    public void dockerPs() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.docker(UnixParameter.create("ps")).exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }

    @Test
    public void dockerRm() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.docker(
                        UnixParameter.create("rm"),
                        UnixParameter.createOpts("f"),
                        UnixParameter.create("simpleApp")
                ).exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }

}
