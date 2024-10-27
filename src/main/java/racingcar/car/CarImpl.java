package racingcar.car;

import static racingcar.exception.ExceptionMessage.CAR_NAME_LENGTH;

public class CarImpl implements Car {
    private final String carName;
    private int position;
    public static Integer MOVE_THRESHOLD = 4;

    public CarImpl(String carName) {
        this.carName = carName;
        carNameValidation();
        position = 0;
    }

    @Override
    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            this.position += 1;
        }
    }

    @Override
    public String getCarName() {
        return carName;
    }

    @Override
    public int getPosition() {
        return position;
    }

    private void carNameValidation() {
        if (isNameSizeOneToFive()) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH);
        }
    }

    private boolean isNameSizeOneToFive() {
        return carName.length() > 5 || carName.isBlank();
    }
}
