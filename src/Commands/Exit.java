package Commands;

import java.util.Scanner;

/**
 * Команда, совершающая выход из программы.
 */
public class Exit implements CommandableWithoutArgument {

    public Exit() {
        Commands.regist("exit", this);
    }

    @Override
    public void execute() {
        System.out.println("Вы точно хотите выйти из программы, ничего не сохранив?");
        System.out.println("Ввведите \"yes\", если да или нажмите \"Enter\" для отмены.");
        System.out.print("$ ");
        String answer = new Scanner(System.in).nextLine();
        if (answer.equals("yes")) System.exit(0);
    }
}
