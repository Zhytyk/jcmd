package com.jcmd.core;

import com.jcmd.core.impl.UnixCmderPipeline;
import com.jcmd.core.impl.args.UnixParameter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UnixCmderRunFileTest {

    @Test
    public void runFile() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.runFile("/Users/pavel/IdeaProjects/jcmd/src/test/resources/do-version.sh")
                        .exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());

    }

    @Test
    public void runFileWithArgs() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.runFile("/Users/pavel/IdeaProjects/jcmd/src/test/resources/do-version.sh",
                        UnixParameter.create("'Hello Paul'"))
                        .exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }

    @Test
    public void runGradlew() {
        UnixCmder unixCmder = UnixCmderPipeline.create();
        List<CmdResponse> responses =
                unixCmder.runFile("/Users/pavel/IdeaProjects/jcmd/gradlew")
                        .exec();

        Assert.assertEquals(1, responses.size());
        System.out.println(responses.get(0).getOutput());
    }
}
