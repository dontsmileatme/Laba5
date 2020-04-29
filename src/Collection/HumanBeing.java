package Collection;

import java.time.ZonedDateTime;

/**
 * Коллекция заполняется экземлярами данного класса - человека.
 */
public class HumanBeing implements Comparable<HumanBeing> {
    private long id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private boolean realHero;
    private boolean hasToothpick;
    private long impactSpeed;
    private double minutesOfWaiting;
    private WeaponType weaponType;
    private Mood mood;
    private Car car;
    private static long numberForId = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        numberForId++;
        this.setId(numberForId);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isRealHero() {
        return realHero;
    }

    public void setRealHero(boolean realHero) {
        this.realHero = realHero;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public long getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(long impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public class Coordinates {
        private Double x;
        private Long y;

        public Double getX() {
            return x;
        }

        public void setX(Double x) {
            this.x = x;
        }

        public Long getY() {
            return y;
        }

        public void setY(Long y) {
            this.y = y;
        }
    }

    public class Car {
        private String name;
        private Boolean cool;

        public String getCarName() {
            return name;
        }

        public void setCarName(String name) {
            this.name = name;
        }

        public Boolean isCarCool() {
            return cool;
        }

        public void setCarCool(Boolean cool) {
            this.cool = cool;
        }
    }

    public enum WeaponType {
        HAMMER("Молоток"),
        AXE("Топор"),
        RIFLE("Винтовка"),
        KNIFE("Нож"),
        BAT("Дубинка");

        private final String title;

        WeaponType(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public enum Mood {
        SADNESS("Грусть"),
        SORROW("Печаль"),
        LONGING("Вожделение"),
        APATHY("Апатия");

        private final String title;

        Mood(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public String getHumanBeing() {
        if (this.car != null && !this.car.equals("") && this.car.isCarCool() != null && this.car.getCarName() != null) {
        return "Человек (" +
                "id: " + this.getId() + "):" +
                "\n\tИмя: " + this.getName() +
                ";\n\tКоординаты: " +
                "\n\t\tx = " + this.coordinates.getX() +
                ";\n\t\ty = " + this.coordinates.getY() +
                ";\n\tДата создания: " + this.getCreationDate() +
                ";\n\tНастоящий ли герой: " + this.isRealHero() +
                ";\n\tЕсть ли зубочистка: " + this.isHasToothpick() +
                ";\n\tСкорость удара: " + this.getImpactSpeed() +
                ";\n\tВремя ожидания в минутах: " + this.getMinutesOfWaiting() +
                ";\n\tВид оружия: " + this.weaponType.getTitle() +
                ";\n\tНастроение: " + this.mood.getTitle() +
                ";\n\tМашина: " +
                "\n\t\tМарка машины: " + this.car.getCarName() +
                ";\n\t\tКрута ли машина: " + this.car.isCarCool() + ".\n";
    } else return "Человек (" +
                "id: " + this.getId() + "):" +
                "\n\tИмя: " + this.getName() +
                ";\n\tКоординаты: " +
                "\n\t\tx = " + this.coordinates.getX() +
                ";\n\t\ty = " + this.coordinates.getY() +
                ";\n\tДата создания: " + this.getCreationDate() +
                ";\n\tНастоящий ли герой: " + this.isRealHero() +
                ";\n\tЕсть ли зубочистка: " + this.isHasToothpick() +
                ";\n\tСкорость удара: " + this.getImpactSpeed() +
                ";\n\tВремя ожидания в минутах: " + this.getMinutesOfWaiting() +
                ";\n\tВид оружия: " + this.weaponType.getTitle() +
                ";\n\tНастроение: " + this.mood.getTitle() + ".\n";
    }

    @Override
    public int compareTo(HumanBeing human) {
        return ((int) ((human.getImpactSpeed() + human.getMinutesOfWaiting()) - (this.getImpactSpeed() + this.getMinutesOfWaiting())));
    }
}
