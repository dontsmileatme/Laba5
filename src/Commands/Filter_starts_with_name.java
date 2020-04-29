package Commands;

import Collection.HumanBeing;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Команда, выводящая элементы, значение поля name которых начинается с заданной подстроки.
 */
public class Filter_starts_with_name implements CommandableWithArgument {

    public Filter_starts_with_name() {
        Commands.regist("filter_starts_with_name", this);
    }

    @Override
    public void execute(String arg) {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            try {
                if (arg != null && !arg.equals("")) {
                    Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
                    ArrayList<String> names = new ArrayList();
                    while (iterator.hasNext()) {
                        HumanBeing human = iterator.next();
                        if (human.getName().startsWith(arg)) names.add(human.getName());
                    }
                    if (!names.isEmpty()) {
                        for (String name : names) System.out.println(name);
                    } else {
                        System.out.println("Имени по заданной подстроке не нашлось.");
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("Значение должно быть типа \"String\". Введите значение заново.");
                System.out.println("Введите значение аргумента: ");
                System.out.print("$ ");
                String input = new Scanner(System.in).nextLine();
                this.execute(input);
            }
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}
