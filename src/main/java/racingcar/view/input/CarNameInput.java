package racingcar.view.input;

import racingcar.exception.view.CarNameInputErrorMessage;
import racingcar.util.CarNameValidator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameInput {
    public Set<String> process(String input) {
        CarNameValidator.validateInput(input); // 입력 값 유효성 검사

        List<String> carNames = splitCarNames(input);
        return createCarNameSet(carNames);
    }

    private List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    private Set<String> createCarNameSet(List<String> carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            CarNameValidator.validateCarName(trimmedName); // 자동차 이름 유효성 검사
            if (!carNameSet.add(trimmedName)) {
                throw new IllegalArgumentException(CarNameInputErrorMessage.CAR_NAME_DUPLICATE.getMessage()); // 자동차 이름 중복성 검사
            }
        }
        return carNameSet;
    }
}