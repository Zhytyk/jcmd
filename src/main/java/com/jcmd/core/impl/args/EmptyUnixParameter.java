package com.jcmd.core.impl.args;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

public class EmptyUnixParameter extends UnixParameter {

    private EmptyUnixParameter() {
        super(Collections.emptyList(), Collections.emptyList());
    }

    public static EmptyUnixParameter create() {
        return new EmptyUnixParameter();
    }

    @Override
    public String convertToString() {
        return StringUtils.EMPTY;
    }
}
