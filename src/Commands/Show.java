package Commands;

/**
 * Команда, выводящая все элементы коллекции.
 */
public class Show implements CommandableWithoutArgument {

    public Show() {
        Commands.regist("show", this);
    }

    @Override
    public void execute() {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            HumanBeingCollection.getCollection().forEach(humanBeing -> System.out.println(humanBeing.getHumanBeing()));
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
