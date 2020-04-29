import Collection.*;
import Commands.*;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/***
 * @version 1.0
 * @author Andrew
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String filepath = System.getenv("JavaTextFile");
        HumanBeingCollection humanBeingCollection = new HumanBeingCollection();
        FillingTheCollection.fillTheCollection(filepath);
        Commands invoker = new Commands();

        Add add = new Add();
        Add_if_max add_if_max = new Add_if_max();
        Clear clear = new Clear();
        Count_by_impact_speed count_by_impact_speed = new Count_by_impact_speed();
        Execute_script execute_script = new Execute_script();
        Exit exit = new Exit();
        Filter_starts_with_name filter_starts_with_name = new Filter_starts_with_name();
        Head head = new Head();
        Help help = new Help();
        Info info = new Info();
        Print_field_descending_minutes_of_waiting print_field_descending_minutes_of_waiting = new Print_field_descending_minutes_of_waiting();
        Remove_by_id remove_by_id = new Remove_by_id();
        Remove_greater remove_greater = new Remove_greater();
        Save save = new Save();
        Show show = new Show();
        Update update = new Update();

        System.out.println("Введите команду: ");
        while (true) {
            try {
                System.out.print("$ ");
                Scanner scanner = new Scanner(System.in);
                String commandName = scanner.nextLine();
                if (!commandName.equals("")) invoker.execute(commandName);
            } catch (NoSuchElementException e) {
                System.exit(0);
            }
        }
    }
}
