package Commands;

import Collection.HumanBeing;
import Tools.CreationOfHuman;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Команда, обновляющая элемент коллекции по id.
 */
public class Update implements CommandableWithArgument {

    public Update() {
        Commands.regist("update", this);
    }

    @Override
    public void execute(String arg) {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            long inputtedId;
            boolean idHasFound = false;
            HumanBeing foundedHuman = null;
            try {
                if (arg != null && !arg.equals("")) {
                    inputtedId = Long.parseLong(arg);
                    Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
                    while (iterator.hasNext()) {
                        HumanBeing human = iterator.next();
                        if (human.getId() == inputtedId) {
                            idHasFound = true;
                            foundedHuman = human;
                        }
                    }
                    if (idHasFound) {
                        HumanBeing inputtedHuman = new CreationOfHuman().create();
                        inputtedHuman.setId(inputtedId);
                        HumanBeingCollection.getCollection().remove(foundedHuman);
                        HumanBeingCollection.getCollection().add(inputtedHuman);
                        System.out.println("Элемент с \"id\" — " + inputtedId + " успешно заменён.");
                    } else System.out.println("Нет элемента с указанным \"id\"");
                }
            } catch (NumberFormatException ex) {
                System.out.println(("Значение \"id\" должно быть целым неторицательным числом."));
                System.out.println("Введите значение аргумента: ");
                System.out.print("$ ");
                String input = new Scanner(System.in).nextLine();
                this.execute(input);
            }
        } else System.out.println("Коллекция пустая.");
    }
}
