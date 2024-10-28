package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    public void validateCarNamesInput(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.isEmpty()) {
            throw new IllegalArgumentException("입력 값은 빈 값일 수 없습니다.");
        }
    }

    public String[] validateCarNames(String[] carNames) {
        validateCarCount(carNames);
        String[] validatedCarNames = validateName(carNames);
        validateUniqueNames(validatedCarNames);
        return validatedCarNames;
    }

    private void validateCarCount(String[] carNames) {
        if (carNames.length <= 1) {
            throw new IllegalArgumentException("경주에 참여하는 자동차는 2대 이상이어야 합니다.");
        }
    }

    private String[] validateName(String[] carNames) {
        String[] trimmedCarNames = new String[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            String trimmedCarName = carNames[i].trim();
            if (trimmedCarName.isEmpty() || trimmedCarName.length() > 5) {
                throw new IllegalArgumentException("바르지 않은 자동차 이름이 있습니다.");
            }
            trimmedCarNames[i] = trimmedCarName;
        }
        return trimmedCarNames;
    }

    private void validateUniqueNames(String[] validatedCarNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(validatedCarNames));
        if (uniqueNames.size() < validatedCarNames.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
