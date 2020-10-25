package com.jcmd.core.impl.parallel;

import java.util.List;

public class ParallelTaskExecutorResult {
    private List<UnixCmderResult> parallelUnixCmderResults;
    private List<UnixCmderResult> joinUnixCmderResults;

    private ParallelTaskExecutorResult(List<UnixCmderResult> parallelUnixCmderResults,
                                       List<UnixCmderResult> joinUnixCmderResults) {
        this.parallelUnixCmderResults = parallelUnixCmderResults;
        this.joinUnixCmderResults = joinUnixCmderResults;
    }

    public static ParallelTaskExecutorResult create(
            List<UnixCmderResult> parallelUnixCmderResults,
            List<UnixCmderResult> joinUnixCmderResults) {
        return new ParallelTaskExecutorResult(
                parallelUnixCmderResults,
                joinUnixCmderResults);
    }

    public List<UnixCmderResult> getParallelUnixCmderResults() {
        return parallelUnixCmderResults;
    }

    public List<UnixCmderResult> getJoinUnixCmderResults() {
        return joinUnixCmderResults;
    }
}
