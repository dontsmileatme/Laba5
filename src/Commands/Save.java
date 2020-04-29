package Commands;

import Tools.WriterToFile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Команда, сохраняющая коллекцию.
 */
public class Save implements CommandableWithoutArgument {

    public Save() {
        Commands.regist("save", this);
        }

    @Override
    public void execute() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String data = gson.toJson(HumanBeingCollection.getCollection());
        WriterToFile.writeToFile(data);
    }
}
