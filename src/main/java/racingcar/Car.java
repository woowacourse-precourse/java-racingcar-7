package racingcar;

public class Car {

    private final String name;
    private String position;

    private Car(String name) {
        this.name = name;
        this.position = "";
    }
    public static Car generateCars(String carName) {
        return new Car(carName);
    }

    public String getName() {
        return name;
    }

    public void move(int moveNum) {
        if (moveNum >= 4) {
            position += "-";
        }
    }

    @Override
    public String toString() {
        return getName() + " : " + position;
    }
}
