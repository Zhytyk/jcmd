package com.jcmd.core.impl.cmds;

import com.jcmd.core.CmdResponse;
import com.jcmd.core.Command;
import com.jcmd.core.Constants;
import com.jcmd.core.impl.responses.CompositeCmdResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CompositeCommand implements Command {
    private List<Command> commands;

    private CompositeCommand(List<Command> commands) {
        this.commands = commands;
    }

    public static CompositeCommand create(List<Command> commands) {
        return new CompositeCommand(commands);
    }

    @Override
    public String getCommand() {
        return commands.stream()
                .map(Command::getCommand)
                .reduce((c1, c2) -> c1 + Constants.SEMICOLON + c2)
                .orElse(StringUtils.EMPTY);
    }

    @Override
    public CmdResponse createResponse(String output) {
        return CompositeCmdResponse.create(this, output);
    }
}
