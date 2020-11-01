package com.jcmd.core.impl.executors;

import com.jcmd.core.Executable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface Executor {
    InputStream execute(Executable executable) throws IOException;

    String directory();

    ProcessBuilder directory(File file);

}
