package racingcar.domain;

import java.util.Objects;
import racingcar.global.ErrorMessage;

public class Car {
    private final String name;
    private int position;
    private final MovingStrategy movingStrategy;
    private static final Integer MAX_NAME_LENGTH = 5;

    public Car(String inputName, MovingStrategy movingStrategy) {
        validate(inputName);
        this.name = inputName;
        this.movingStrategy = movingStrategy;
    }

    public void move() {
        if (movingStrategy.shouldMove()){
            position++;
        }
    }

    private void validate(String inputName){
        if (Objects.isNull(inputName) || inputName.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME.getMessage());
        }

        if (inputName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
