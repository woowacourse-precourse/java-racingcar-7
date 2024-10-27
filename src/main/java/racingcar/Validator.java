package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    final static String CAR_NAME_SEPARATOR = ",";
    final static Integer MINIMUM_NUMBER_CAR_NAME_LENGTH = 5;
    public static String CAR_NAME_LENGTH_ERROR_MESSAGE = "차의 이름을 5글자 이하로 입력해주세요.";
    public static String CAR_NAME_REPEAT_ERROR_MESSAGE = "중복된 이름 입니다.";
    public static String CAR_NAME_EMPTY_ERROR_MESSAGE = "중복된 이름 입니다.";

    final private String carNames;

    public Validator(String carNames) {
        this.carNames = carNames;
    }


    public void validate() {
        checkSameCarNames(separateCarNames());
        checkLengthCarNames(separateCarNames());
        checkEmptyCarNames(separateCarNames());
    }

    public String[] separateCarNames() {
        return carNames.split(CAR_NAME_SEPARATOR);
    }

    public void checkLengthCarNames(String[] cars) {
        for (String carName:cars) {
            if (carName.length() > MINIMUM_NUMBER_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    public void checkSameCarNames(String[] cars) {
        Set<String> myCars = new HashSet<>(List.of(cars));
        if (cars.length != myCars.size()) {
            throw new IllegalArgumentException(CAR_NAME_REPEAT_ERROR_MESSAGE);
        }
    }

    public void checkEmptyCarNames(String[] cars) {
        for (String carName:cars) {
            if (carName.isBlank() || carName.contains(" ")) {
                throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
            }
        }
    }
}
