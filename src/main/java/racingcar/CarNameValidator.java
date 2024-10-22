package racingcar;

import java.util.Arrays;

public class CarNameValidator {
    final String carNames = InputController.printCarNamesInput();
    final String tryTimes = InputController.printTryTimesInput();

    public String[] separateCarNames() {
        return carNames.split(",");
    }

    public void checkLengthCarNames() {
        System.out.println(Arrays.toString(separateCarNames()));
        for (String carName:separateCarNames()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void changeTryTimesNumber() {
        try {
            Integer.parseInt(tryTimes);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
