package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public int moveForwardIf(boolean possible) {
        if (possible) {
            position++;
            return position;
        }
        return -1;
    }

    public CurrentCar createCurrentCar() {
        return new CurrentCar(name, position);
    }
}
