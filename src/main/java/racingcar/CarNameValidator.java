package racingcar;

import java.util.Arrays;

public class CarNameValidator {
    final String carNames = InputController.printCarNamesInput();

    public String[] separateCarNames() {
        return carNames.split(",");
    }

    public void checkLengthCarNames() {
        System.out.println(Arrays.toString(separateCarNames()));
        if (separateCarNames().length > 5) {
            throw new IllegalArgumentException();
        }
    }

}
