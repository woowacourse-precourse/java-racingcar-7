package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final Name name;
    private Position position;

    public Car(String carName) {
        this.name = Name.newInstance(carName);
        this.position = Position.newInstance();
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generateNumber() >= MOVE_THRESHOLD) {
            this.position = position.increment();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
