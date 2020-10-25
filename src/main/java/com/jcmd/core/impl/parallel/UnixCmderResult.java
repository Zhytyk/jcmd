package com.jcmd.core.impl.parallel;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.UnixCmder;
import com.jcmd.core.exceptions.CmderResponseException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UnixCmderResult {
    private UnixCmder unixCmder;
    private Future<List<CmdResponse>> futureResponses;

    private UnixCmderResult(UnixCmder unixCmder,
                            Future<List<CmdResponse>> futureResponses) {
        this.unixCmder = unixCmder;
        this.futureResponses = futureResponses;
    }

    public static UnixCmderResult create(UnixCmder cmder,
                                         Future<List<CmdResponse>> responses) {
        return new UnixCmderResult(cmder, responses);
    }

    public List<CmdResponse> getResponse() {
        try {
            return futureResponses.get();
        } catch (Exception e) {
            throw new CmderResponseException(e);
        }
    }
}
