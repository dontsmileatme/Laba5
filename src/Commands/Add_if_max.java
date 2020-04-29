package Commands;

import Collection.HumanBeing;
import Tools.CreationOfHuman;

/**
 * Команда, добавляющая элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции.
 */
public class Add_if_max implements CommandableWithoutArgument{

    public Add_if_max() {
        Commands.regist("add_if_max", this);
    }

    @Override
    public void execute() {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            HumanBeing createdHuman = new CreationOfHuman().create();
            if (createdHuman.compareTo(HumanBeingCollection.getCollection().peek()) < 0) {
                HumanBeingCollection.addToCollection(createdHuman);
                System.out.println("Человек успешно добавлен в коллекцию.");
            } else {
                System.out.println("Человек не добавлен в коллекцию.");
            }
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
