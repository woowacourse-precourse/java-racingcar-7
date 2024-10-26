package domain;

import constant.Race;
import java.util.Objects;
import validator.CarValidator;

public class Car {
    private final String name;
    private int score = 0;

    public Car(String name) {
        CarValidator.isNameEmpty(name);
        CarValidator.isNameLengthExceed(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public void moveOrStop(int value) {
        if (value >= Race.MOVE_THRESHOLD.getValue())
            this.score += Race.MOVE_STEP.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return score == car.score && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
