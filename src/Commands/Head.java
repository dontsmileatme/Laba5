package Commands;

import Collection.HumanBeing;

/**
 * Команда, выводящая первый элемент коллекции.
 */
public class Head implements CommandableWithoutArgument {

    public Head(){
        Commands.regist("head", this);
    }

    @Override
    public void execute() {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            HumanBeing human = HumanBeingCollection.getCollection().peek();
            System.out.println(human.getHumanBeing());
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
