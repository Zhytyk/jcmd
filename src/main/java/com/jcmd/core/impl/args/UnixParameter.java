package com.jcmd.core.impl.args;

import com.google.common.collect.Lists;
import com.jcmd.core.Constants;
import com.jcmd.core.Parameter;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

public class UnixParameter implements Parameter {
    private List<String> options;
    private List<String> arguments;

    public static Parameter create(String... parameters) {
        return new UnixParameter(Collections.emptyList(),
                Lists.newArrayList(parameters));
    }

    public static Parameter createOpts(String... options) {
        return new UnixParameter(Lists.newArrayList(options),
                Collections.emptyList());
    }

    public static Parameter createParamsAndOpts(List<String> params,
                                                List<String> options) {
        return new UnixParameter(Lists.newArrayList(options),
                Lists.newArrayList(params));
    }

    protected UnixParameter(List<String> options, List<String> arguments) {
        this.options = options;
        this.arguments = arguments;
    }

    @Override
    public String convertToString() {
        StringBuilder optionsStr = new StringBuilder(StringUtils.join(options," -"));
        if (optionsStr.length() > 0) {
            optionsStr.insert(0, Constants.OPTION_SEP);
        }

        String argumentsStr = StringUtils.join(arguments, Constants.SPACE);

        return StringUtils.trim(optionsStr.toString()) +
                Constants.SPACE +
                StringUtils.trim(argumentsStr);
    }
}
