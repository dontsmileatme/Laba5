package Tools;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Считывание команд из скрипта.
 */
public class ReaderFromScript {
    static ArrayList<String> scriptNames = new ArrayList<>();

    public static ArrayList<String> getScriptNames() {
        return scriptNames;
    }

    /**
     *
     * @param filepath
     * @return считанные команды в виде String
     */
    public static String readFromScript(String filepath) {
        try {
            FileReader reader = new FileReader(new File(filepath));
            String data = "";
            while (reader.ready()) {
                data += (char) reader.read();
            }
            scriptNames.add(filepath);
            reader.close();
            return data;
        } catch (Exception ex) {
            System.out.println("Заданный файл не найден.");
        }
        return null;
    }
}
