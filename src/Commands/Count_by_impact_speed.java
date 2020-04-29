package Commands;

import Collection.HumanBeing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Команда, выводящая количество элементов, значение поля impactSpeed которых меньше заданного.
 */
public class Count_by_impact_speed implements CommandableWithArgument {

    public Count_by_impact_speed() {
        Commands.regist("count_by_impact_speed", this);
    }

    @Override
    public void execute(String arg) {
        if (!HumanBeingCollection.getCollection().isEmpty()) {
            long inputtedImpactSpeed;
            try {
                if (arg != null && !arg.equals("")) {
                    inputtedImpactSpeed = Long.parseLong(arg);
                    if (inputtedImpactSpeed >= 0 && inputtedImpactSpeed <= 383) {
                        ArrayList<Long> impactSpeeds = new ArrayList();
                        Iterator<HumanBeing> iterator = HumanBeingCollection.getCollection().iterator();
                        while (iterator.hasNext()) {
                            HumanBeing human = iterator.next();
                            if (human.getImpactSpeed() == inputtedImpactSpeed) impactSpeeds.add(human.getImpactSpeed());
                        }
                        if (!(impactSpeeds.size() == 0)) System.out.println(impactSpeeds.size());
                        else System.out.println("Значений, равных заданному, не нашлось.");
                    } else {
                        System.out.println(("Значение impactSpeed должно быть типа \"long\", неотрицательным и не больше 383."));
                        System.out.println("Введите значение аргумента: ");
                        System.out.print("$ ");
                        String input = new Scanner(System.in).nextLine();
                        this.execute(input);
                    }
                } else {
                    System.out.println("Коллекция пустая.");
                }
            } catch (NumberFormatException ex) {
                System.out.println(("Значение impactSpeed должно быть типа \"long\", неотрицательным и не больше 383."));
                System.out.println("Введите значение аргумента: ");
                System.out.print("$ ");
                String input = new Scanner(System.in).nextLine();
                this.execute(input);
            }
        }
    }
}

