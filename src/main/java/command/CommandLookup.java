package command;

public enum CommandLookup {
    R(new TurnRightCommand()),

    L(new TurnLeftCommand()),

    M(new MoveForwardCommand()),

    B(new MoveBackCommand());

    private final Command command;

    CommandLookup(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
