package racingcar.service;

import java.util.List;
import racingcar.validator.StringValidator;

public class InputValidationService {

    private final StringValidator stringValidator;

    public InputValidationService() {
        this.stringValidator = new StringValidator();
    }

    public void validateRawCarNames(String rawCarNames) {
        stringValidator.isNull(rawCarNames);
        stringValidator.isBlank(rawCarNames);
        hasOneCarName(rawCarNames);
        hasBlankCarName(rawCarNames);
        hasTooLongCarName(rawCarNames);
    }

    private void hasOneCarName(String rawCarNames) {
        if (!rawCarNames.contains(",")) {
            throw new IllegalArgumentException("자동차 1대의 이름만 입력되었습이다.");
        }
    }

    private void hasBlankCarName(String rawCarNames) {
        if (rawCarNames.startsWith(",") || rawCarNames.endsWith(",")) {
            throw new IllegalArgumentException("비어있는 자동차 이름이 입력되었습니다.");
        }
        List<String> carNames = List.of(rawCarNames.split(","));
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).isBlank()) {
                throw new IllegalArgumentException("비어있는 자동차 이름이 입력되었습니다.");
            }
        }
    }

    private void hasTooLongCarName(String rawCarNames) {
        List<String> carNames = List.of(rawCarNames.split(","));
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException("5자 이상의 자동차 이름이 입력되었습니다.");
            }
        }
    }

    public void validateRawRoundCount(String rawRoundCount) {
        stringValidator.isNull(rawRoundCount);
        stringValidator.isBlank(rawRoundCount);
        stringValidator.isNotNumeric(rawRoundCount);
        stringValidator.isOutOfIntegerRange(rawRoundCount);
        stringValidator.isZeroOrMinus(rawRoundCount);
    }
}
