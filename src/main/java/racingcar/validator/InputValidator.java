package racingcar.validator;


import racingcar.util.Separator;

import java.util.stream.Stream;

import static racingcar.constant.LengthLimit.LENGTH_LIMIT;

public class InputValidator {

    private final Separator separator = new Separator();

    public void validateInput(String carNames) {
        validateCarNameLength(separator.separate(carNames));
    }

    private void validateCarNameLength(String[] separatedCarNames) {
        Stream.of(separatedCarNames)
                .forEach(carName -> {
                    if (biggerThanLimit(carName)) {
                        throw new IllegalArgumentException();
                    }
                });
    }

    private boolean biggerThanLimit(String carName) {
        return carName.length() > LENGTH_LIMIT.value();
    }
}
