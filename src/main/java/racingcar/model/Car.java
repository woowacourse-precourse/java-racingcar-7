package racingcar.model;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean canMoveUsing(int randomNumber) {
        return (randomNumber >= 4);
    }

    public String getName() {
        return name;
    }
}
