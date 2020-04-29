package Commands;

import java.util.Scanner;

/**
 * Команда, очищающая коллекцию.
 */
public class Clear implements CommandableWithoutArgument {

    public Clear() {
        Commands.regist("clear", this);
    }

    @Override
    public void execute() {
        System.out.println("Вы точно хотите очистить коллекцию?");
        System.out.println("Ввведите \"yes\", если да или нажмите \"Enter\" для отмены.");
        System.out.print("$ ");
        String answer = new Scanner(System.in).nextLine();
        if (answer.equals("yes")) HumanBeingCollection.humans.clear();
    }
}
