package Tools;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс, записывающий коллекцию в файл.
 */
public class WriterToFile {
    private static String filepath;

    public static void setFilepath(String name) {
        filepath = name;
    }

    /**
     *
     * @param data - данные, необходимые сохранить в файл
     */
    public static void writeToFile(String data) {
        FileWriter writer;
        try {
            if (new File(WriterToFile.filepath).exists()) {
                writer = new FileWriter(new File(WriterToFile.filepath));
                writer.write(data);
                writer.close();
                System.out.println("Коллекция сохранена в файл " + filepath);
            } else {
                System.out.println("Программа не может найти файл по заданной директории.");
                throw new NullPointerException();
            }
        } catch (IOException ex) {
            System.out.println("Программа не может найти такой файл.");
        } catch (NullPointerException e) {
            System.out.println("Укажите путь сохранения коллекции: ");
            System.out.print("$ ");
            String newFilepath = new Scanner(System.in).nextLine();
            WriterToFile.filepath = newFilepath;
            writeToFile(data);
        }
    }
}

