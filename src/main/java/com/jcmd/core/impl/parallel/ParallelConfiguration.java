package com.jcmd.core.impl.parallel;

public class ParallelConfiguration {
    private boolean isCachedExecutorService;
    private int threads;

    private ParallelConfiguration(boolean isCachedExecutorService) {
        this.isCachedExecutorService = isCachedExecutorService;
    }

    private ParallelConfiguration(int threads) {
        this.threads = threads;
    }

    public static ParallelConfiguration create(boolean isCachedExecutorService) {
        return new ParallelConfiguration(isCachedExecutorService);
    }

    public static ParallelConfiguration create(int threads) {
        return new ParallelConfiguration(threads);
    }

    public boolean isCachedExecutorService() {
        return isCachedExecutorService;
    }

    public int getThreads() {
        return threads;
    }
}
