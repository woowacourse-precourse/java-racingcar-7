package racingcar.entity;

import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

import java.util.Objects;

public class Input {

    private final String value;

    public Input(String input) {
        if (input == null) {
            throw new IllegalStateException("적절한 입력을 해야합니다.");
        }

        this.value = input;
    }

    public CarList toCarList() {
        String[] splitInput = value.split(",");
        CarList carList = new CarList();

        if (splitInput.length == 0) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        for (String name : splitInput) {
            int length = name.length();
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
            }

            if (length > 5 || length == 0) {
                throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
            }

            carList.add(name);
        }

        return carList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Input input1 = (Input) o;
        return Objects.equals(value, input1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
