package Tools;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Считывание коллекции из файла.
 */
public class ReaderFromFile {
    /**
     *
     * @param filepath
     * @return считанную информацию с файла в виде String
     * @throws IOException
     */
    public static String readFromFile(String filepath) throws IOException {
        try {
            File file = new File(filepath);
            FileReader reader = new FileReader(file);
            String data = "";
            while (reader.ready()) {
                data += (char) reader.read();
            }
            WriterToFile.setFilepath(filepath);
            reader.close();
            return data;
        } catch (NullPointerException | IOException ex) {
            System.out.println("Программа не может найти такой файл.");
        } return null;
    }
}
