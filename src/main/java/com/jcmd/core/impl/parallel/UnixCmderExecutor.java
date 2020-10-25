package com.jcmd.core.impl.parallel;


import com.google.common.collect.Lists;
import com.jcmd.core.CmderExecutor;
import com.jcmd.core.UnixCmder;
import com.jcmd.core.exceptions.NoParallelInfoException;

import java.util.Deque;
import java.util.List;

public class UnixCmderExecutor implements CmderExecutor {
    private ParallelConfiguration config;
    private Deque<ParallelTaskExecutor> parallelTaskExecutorQueue =
            Lists.newLinkedList();

    private UnixCmderExecutor(ParallelConfiguration config) {
        this.config = config;
    }

    public static UnixCmderExecutor create(ParallelConfiguration config) {
        return new UnixCmderExecutor(config);
    }

    @Override
    public CmderExecutor parallel(UnixCmder... cmders) {
        addParallels(Lists.newArrayList(cmders));
        return this;
    }

    @Override
    public CmderExecutor parallel(List<UnixCmder> cmders) {
        addParallels(cmders);
        return this;
    }

    private void addParallels(List<UnixCmder> cmders) {
        ParallelTaskExecutor parallelTaskExecutor = parallelTaskExecutorQueue.peekLast();
        if (parallelTaskExecutor == null || parallelTaskExecutor.hasJoins()) {
            parallelTaskExecutor = ParallelTaskExecutor.create(config);
            parallelTaskExecutor.addParallelUnixCmders(cmders);
        }

        parallelTaskExecutorQueue.offer(parallelTaskExecutor);
    }

    @Override
    public CmderExecutor join(UnixCmder... cmders) {
        addJoins(Lists.newArrayList(cmders));
        return this;
    }

    @Override
    public CmderExecutor join(List<UnixCmder> cmders) {
        addJoins(cmders);
        return this;
    }

    private void addJoins(List<UnixCmder> cmders) {
        ParallelTaskExecutor parallelTaskExecutor = parallelTaskExecutorQueue.peekLast();
        if (parallelTaskExecutor == null) {
            throw new NoParallelInfoException();
        }

        parallelTaskExecutor.addJoinUnixCmders(cmders);
    }

    @Override
    public List<ParallelTaskExecutorResult> exec() {
        List<ParallelTaskExecutorResult> result = Lists.newArrayList();
        for (ParallelTaskExecutor executor : parallelTaskExecutorQueue) {
            result.add(executor.execute());
        }

        return result;
    }
}
