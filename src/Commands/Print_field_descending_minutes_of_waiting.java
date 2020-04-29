package Commands;

import Collection.HumanBeing;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;

/**
 * Команда, выводящая значения поля minutesOfWaiting в порядке убывания.
 */
public class Print_field_descending_minutes_of_waiting implements CommandableWithoutArgument {

    public Print_field_descending_minutes_of_waiting() {
        Commands.regist("print_field_descending_minutes_of_waiting", this);
    }

    @Override
    public void execute() {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            ArrayList<Double> minutes = new ArrayList();
            Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
            while (iterator.hasNext()) {
                HumanBeing human = iterator.next();
                minutes.add(human.getMinutesOfWaiting());
            }
            Collections.sort(minutes, Collections.reverseOrder());
            for (double min : minutes) System.out.println(min);
        } else {
            System.out.println("Коллекция пустая.");
        }
    }
}

