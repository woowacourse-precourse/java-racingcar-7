package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    final static String CAR_NAME_SEPARATOR = ",";
    final static Integer MINIMUM_NUMBER_CAR_NAME_LENGTH = 5;

    String carNames;
//    final private InputController inputController;

    public Validator(String carNames) {
        this.carNames = carNames;
    }
//    public Validator(InputController inputController) {
//        this.inputController = inputController;
//    }

    public void validate() {
        checkSameCarNames(separateCarNames());
        checkLengthCarNames(separateCarNames());
    }

    public String[] separateCarNames() {
        return carNames.split(CAR_NAME_SEPARATOR);
    }

    public void checkLengthCarNames(String[] cars) {
        for (String carName:cars) {
            if (carName.length() > MINIMUM_NUMBER_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkSameCarNames(String[] cars) {
        Set<String> myCars = new HashSet<>(List.of(cars));
        if (cars.length != myCars.size()) {
            throw new IllegalArgumentException();
        }
    }

//    public Integer changeTryTimesNumber() {
//        String tryNumber = inputController.printTryTimesInput();
//
//        if (!Pattern.matches(REGEX_PATTERN,tryNumber)){
//            throw new IllegalArgumentException();
//        }
//        return Integer.parseInt(tryNumber);
//    }
}
