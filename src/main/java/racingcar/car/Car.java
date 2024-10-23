package racingcar.car;

import java.util.Objects;
import racingcar.ErrorMessage;

public class Car {
    private final String name;
    private int position;

    public Car(String inputName) {
        validateBlank(inputName);
        this.name = inputName;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()){
            position++;
        }
    }

    private void validateBlank(String inputName){
        if (Objects.isNull(inputName) || inputName.isBlank()){
            throw new IllegalArgumentException(ErrorMessage.BLANK_CAR_NAME.getMessage());
        }
    }

    public int getPosition() {
        return position++;
    }

    public String getName() {
        return name;
    }
}
