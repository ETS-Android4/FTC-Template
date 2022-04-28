package org.firstinspires.ftc.teamcode.shplib.commands;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;
import java.util.Arrays;

public final class CommandScheduler {
    private static CommandScheduler instance;

    private final ArrayList<Command> commands = new ArrayList<>();
    private final ArrayList<Subsystem> subsystems = new ArrayList<>();
    private Telemetry telemetry;

    public static CommandScheduler getInstance() {
        if (instance == null) instance = new CommandScheduler();
        return instance;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void registerSubsystem(Subsystem subsystem) {
        subsystems.add(subsystem);
    }

    public void registerSubsystems(Subsystem... subsystems) {
        this.subsystems.addAll(Arrays.asList(subsystems));
    }

    public void addCommand(Command command) {
        command.initialize();
        commands.add(command);
    }

    public void addCommands(Command... commands) {
        for (Command command : commands)
            command.initialize();
        this.commands.addAll(Arrays.asList(commands));
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < commands.size(); i++) {
            Command command = commands.get(i);
            command.execute();
            if (command.isFinished()) {
                command.end();
                commands.remove(i);
                i--;
            }
        }

        for (Subsystem subsystem : subsystems) {
            Command defaultCommand = subsystem.getDefaultCommand();
            if (defaultCommand != null) defaultCommand.execute();
            subsystem.periodic(telemetry);
        }
    }
}
