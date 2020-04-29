package Commands;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Invoker-класс, управляющий командами.
 */
public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();

    private Commandable command;
    private String arg;

    public static Map<String, Commandable> getCommands() {
        return commands;
    }

    public Commandable getCommand() {
        return command;
    }

    public String getArg() {
        return arg;
    }

    public static void regist(String commandName, Commandable command) {
        commands.put(commandName, command);
    }

    public void execute(String commandName) throws IOException {
        String[] separatedPartsOfCommand = commandName.split(" ");

        if (separatedPartsOfCommand.length == 1) {
            if ((separatedPartsOfCommand[0].equals("add")) ||
                    (separatedPartsOfCommand[0].equals("add_if_max")) ||
                    (separatedPartsOfCommand[0].equals("clear")) ||
                    (separatedPartsOfCommand[0].equals("exit")) ||
                    (separatedPartsOfCommand[0].equals("head")) ||
                    (separatedPartsOfCommand[0].equals("help")) ||
                    (separatedPartsOfCommand[0].equals("info")) ||
                    (separatedPartsOfCommand[0].equals("print_field_descending_minutes_of_waiting")) ||
                    (separatedPartsOfCommand[0].equals("remove_greater")) ||
                    (separatedPartsOfCommand[0].equals("save")) ||
                    (separatedPartsOfCommand[0].equals("show"))
            ) {
                CommandableWithoutArgument command = (CommandableWithoutArgument) commands.get(separatedPartsOfCommand[0]);
                command.execute();
            } else {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            }
        } else if (separatedPartsOfCommand.length == 2) {
            if ((separatedPartsOfCommand[0].equals("count_by_impact_speed")) ||
                    (separatedPartsOfCommand[0].equals("execute_script")) ||
                    (separatedPartsOfCommand[0].equals("filter_starts_with_name")) ||
                    (separatedPartsOfCommand[0].equals("remove_by_id")) ||
                    (separatedPartsOfCommand[0].equals("update"))) {
                CommandableWithArgument command = (CommandableWithArgument) commands.get(separatedPartsOfCommand[0]);
                this.arg = separatedPartsOfCommand[1];
                command.execute(arg);
            } else
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
        } else if (separatedPartsOfCommand.length > 2) {
            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
        }
    }
}
