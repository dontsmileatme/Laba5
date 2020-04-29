package Commands;

import Tools.*;

/**
 * Команда, добавляющая элемент в коллекцию.
 */
public class Add implements CommandableWithoutArgument {

    public Add() {
        Commands.regist("add", this);
    }

    @Override
    public void execute() {
        HumanBeingCollection.addToCollection(new CreationOfHuman().create());
        System.out.println("Человек успешно добавлен в коллекцию!");
    }
}
