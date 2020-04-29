package Commands;

import Collection.HumanBeing;
import Tools.CreationOfHuman;
import Tools.ReaderFromScript;

import java.io.IOException;
import java.util.Iterator;

/**
 * Команда, исполняющая команды, прописанные в скрипте.
 */
public class Execute_script implements CommandableWithArgument {

    public Execute_script() {
        Commands.regist("execute_script", this);
    }

    CreationOfHuman creation = new CreationOfHuman();
    Commands invoker = new Commands();

    @Override
    public void execute(String arg) {
        try {
            String filepath = arg;
            String data = ReaderFromScript.readFromScript(filepath);
            ReaderFromScript.getScriptNames().add(filepath);

            String[] commands = data.split("\n|\r\n");
            for (int i = 0; i < commands.length; i++) {
                String command = commands[i];
                String[] temp1 = command.split(" ");
                if (temp1[0].equals("add") || temp1[0].equals("add_if_max") || temp1[0].equals("remove_greater")) {
                    String[] params = new String[11];

                    for (int j = 0; j < 11; j++) {
                        i++;
                        params[j] = commands[i];
                        if (params[j].equals("null")) break;
                    }

                    if (temp1[0].equals("add")) {
                        System.out.println("Команда \"add\": ");
                        HumanBeing human = creation.createFromFile(params);
                        HumanBeingCollection.addToCollection(human);
                        System.out.println("Человек успешно добавлен в коллекцию.");
                    }

                    if (temp1[0].equals("add_if_max")) {
                        System.out.println("Команда: \"add_if_max\":");
                        if (!HumanBeingCollection.getCollection().isEmpty()) {
                            HumanBeing createdHuman = creation.createFromFile(params);
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

                    if (temp1[0].equals("remove_greater")) {
                        System.out.println("Команда \"remove_greater\": ");
                        if (!HumanBeingCollection.getCollection().isEmpty()) {
                            int initialSize = HumanBeingCollection.getCollection().size();
                            HumanBeing createdHuman = creation.createFromFile(params);
                            Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
                            while (iterator.hasNext()) {
                                HumanBeing human = iterator.next();
                                if (human.compareTo(createdHuman) < 0)
                                    HumanBeingCollection.getCollection().remove(human);
                            }
                            System.out.println("Удалено " + (initialSize - HumanBeingCollection.getCollection().size()) + " элементов коллекции.");
                        } else {
                            System.out.println("Коллекция пустая.");
                        }
                    }
                } else {
                    String[] temp2 = command.split(" ");
                    if (temp2[0].equals("execute_script")) {
                        if (ReaderFromScript.getScriptNames().contains(temp2[1])) {
                            System.out.println("Команда: \"" + command + "\" неосуществима.");
                        } else {
                            invoker.execute(command);
                            ReaderFromScript.getScriptNames().add(temp2[1]);
                        }
                    } else {
                        String[] temp = command.split(" ");
                        if (command.equals("") || Commands.getCommands().get(temp[0]) == null)
                            System.out.println("Команды: \"" + command + "\" не существует.");
                        else {
                            System.out.println("Команда: \"" + command + "\":");
                            invoker.execute(command);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }
}
