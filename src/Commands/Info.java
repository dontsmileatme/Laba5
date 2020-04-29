package Commands;

/**
 * Команда, выводящая информацию о коллекции.
 */
public class Info implements CommandableWithoutArgument {

    public Info() {
        Commands.regist("info", this);
    }

    @Override
    public void execute() {
        if (HumanBeingCollection.getCollection().size() != 0) {
            System.out.println(HumanBeingCollection.getInfo());
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
