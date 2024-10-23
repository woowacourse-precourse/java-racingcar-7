package racingcar;

import java.util.Arrays;

public class CarNameValidator {
    InputController inputController = new InputController();

    final String carNames = inputController.printCarNamesInput();
    final String tryTimes = inputController.printTryTimesInput();

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

    public Integer changeTryTimesNumber() {
        try {
            return Integer.parseInt(tryTimes);
        }catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
