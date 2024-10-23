package racingcar.domain;

public class Car {
    private final CarName name;
    private Position position;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position(0);
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position = position.increase();
        }
    }
}

