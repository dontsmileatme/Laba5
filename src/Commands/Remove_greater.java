package Commands;

import Collection.HumanBeing;
import Tools.CreationOfHuman;

import java.util.Iterator;

/**
 * Команда, удаляющая все элементы, превышающие заданный.
 */
public class Remove_greater implements CommandableWithoutArgument{

    public Remove_greater() {
        Commands.regist("remove_greater", this);
    }

    @Override
    public void execute() {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            int initialSize = HumanBeingCollection.getCollection().size();
            HumanBeing createdHuman = new CreationOfHuman().create();
            Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
            while (iterator.hasNext()) {
                HumanBeing human = iterator.next();
                if (createdHuman.compareTo(human) < 0) HumanBeingCollection.getCollection().remove(human);
            }
            System.out.println("Удалено " + (initialSize - HumanBeingCollection.getCollection().size()) + " элементов коллекции.");
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
