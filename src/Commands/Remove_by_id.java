package Commands;

import Collection.HumanBeing;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Команда, удаляющая элемент коллекции по id.
 */
public class Remove_by_id implements CommandableWithArgument {

    public Remove_by_id() {
        Commands.regist("remove_by_id", this);
    }

    @Override
    public void execute(String arg) {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            long inputtedId = -1;
            if (arg != null && !arg.equals("")) {
                try {
                    inputtedId = Long.parseLong(arg);
                    Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
                    while (iterator.hasNext()) {
                        HumanBeing human = iterator.next();
                        if (inputtedId == human.getId()) {
                            iterator.remove();
                            System.out.println("Человек с id: " + inputtedId + " успешно удалён.");
                        }
                    } if (inputtedId == -1) System.out.println("Нет человека с таким id");
                } catch (NumberFormatException ex) {
                    System.out.println("Значение id должно быть типа \"long\".");
                    System.out.println("Введите значение аргумента: ");
                    System.out.print("$ ");
                    String input = new Scanner(System.in).nextLine();
                    this.execute(input);
                }
            }
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
