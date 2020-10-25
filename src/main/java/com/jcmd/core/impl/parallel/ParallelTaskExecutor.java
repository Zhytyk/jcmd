package com.jcmd.core.impl.parallel;

import com.google.common.collect.Lists;
import com.jcmd.core.UnixCmder;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ParallelTaskExecutor {
    private ExecutorService executorService;
    private List<UnixCmder> parallelUnixCmders = Lists.newArrayList();
    private List<UnixCmder> joinUnixCmders = Lists.newArrayList();

    private ParallelTaskExecutor(int threads) {
        this.executorService = Executors.newFixedThreadPool(threads);
    }

    private ParallelTaskExecutor() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public static ParallelTaskExecutor create(ParallelConfiguration config) {
        return config.isCachedExecutorService() ? new ParallelTaskExecutor() :
                new ParallelTaskExecutor(config.getThreads());
    }

    public void addParallelUnixCmders(List<UnixCmder> parallelUnixCmders) {
        this.parallelUnixCmders.addAll(parallelUnixCmders);
    }

    public void addJoinUnixCmders(List<UnixCmder> joinUnixCmders) {
        this.joinUnixCmders.addAll(joinUnixCmders);
    }

    public boolean hasJoins() {
        return !joinUnixCmders.isEmpty();
    }

    public ParallelTaskExecutorResult execute() {
        List<UnixCmderResult> parallelUnixResults = submitTasks(parallelUnixCmders);
        parallelUnixResults.forEach(UnixCmderResult::getResponse);

        List<UnixCmderResult> joinUnixResults = submitTasks(joinUnixCmders);
        parallelUnixResults.forEach(UnixCmderResult::getResponse);

        return ParallelTaskExecutorResult.create(parallelUnixResults, joinUnixResults);
    }

    private List<UnixCmderResult> submitTasks(List<UnixCmder> tasks) {
        return tasks.stream()
                .map(cmder ->
                        UnixCmderResult.create(cmder, executorService.submit(cmder::exec)))
                .collect(Collectors.toList());
    }
}
