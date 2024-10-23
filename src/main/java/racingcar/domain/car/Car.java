package racingcar.domain.car;

import racingcar.domain.accelerator.Accelerator;
import racingcar.domain.accelerator.RandomAccelerator;
import racingcar.exception.BusinessException;
import racingcar.exception.RacingCarExceptionMessage;

public class Car {

    private final String name;
    private int position;
    private final Accelerator accelerator;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
        this.accelerator = new RandomAccelerator();
    }

    public void move(Integer number) {
        if (accelerator.isMovable(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (isUsableName(name)) {
            throw new BusinessException(RacingCarExceptionMessage.NAME_LENGTH_OUT_OF_RANGE);
        }
    }

    private boolean isUsableName(String name) {
        return name.trim().length() > 5 || name.trim().isEmpty();
    }
}

