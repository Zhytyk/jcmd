package com.jcmd.core;

import java.util.List;

public interface Cmder {
    List<CmdResponse> exec();
    String directory();
    String home();
    Cmder compose();
}
