package Commands;

import Collection.HumanBeing;

import java.util.PriorityQueue;
import java.util.Date;

/**
 * Reciever-класс, содержащий коллекцию.
 */
public class HumanBeingCollection{
    protected static PriorityQueue<HumanBeing> humans = new PriorityQueue<>();
    protected static Date dateCreation;

    public HumanBeingCollection() {
        dateCreation = new Date();
        PriorityQueue<HumanBeing> humans = new PriorityQueue<>();
        System.out.println("Коллекция создана.");
    }
    public static PriorityQueue<HumanBeing> getCollection() {
        return humans;
    }
    public static void setCollection(PriorityQueue<HumanBeing> collection) {
        humans = collection;
    }
    public static void addToCollection(HumanBeing human) {
        humans.add(human);
    }
    public static int getSize() {
        return humans.size();
    }
    public static Date getDateCreation() {
        return dateCreation;
    }

    public static String getInfo() {
        return "Тип коллекции: Priority Queue" +
                ";\nKоличество элементов коллекции: " + getSize() +
                ";\nДата создания коллекции: " + getDateCreation() + ".";
    }
}