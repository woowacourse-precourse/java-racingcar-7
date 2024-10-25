package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;


    public List<String> processCarNames(String inputCars) {
        validateInput(inputCars);
        List<String> carNames = Arrays.asList(inputCars.split(","));
        validateCarNames(carNames);
        return carNames;
    }


    private void validateInput(String inputCars) {
        if (inputCars == null || inputCars.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    private void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateCarName(name);
        }
    }


    private void validateCarName(String CarName) {
        if (CarName == null || CarName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (CarName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. 입력된 이름: " + CarName);
        }
    }

}
