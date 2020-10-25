package com.jcmd.core;

import com.jcmd.core.impl.parallel.ParallelTaskExecutorResult;

import java.util.List;

public interface CmderExecutor {
    CmderExecutor parallel(UnixCmder... cmders);
    CmderExecutor parallel(List<UnixCmder> cmders);
    CmderExecutor join(UnixCmder... cmders);
    CmderExecutor join(List<UnixCmder> cmders);
    List<ParallelTaskExecutorResult> exec();
}
