package racingcar.validator;


import racingcar.util.MatcherUtils;
import racingcar.util.Separator;

import java.util.stream.Stream;

import static racingcar.constant.Condition.MIN_RACE_COUNT;
import static racingcar.constant.Condition.SINGLE_ELEMENT;
import static racingcar.constant.LengthLimit.LENGTH_LIMIT;

public class InputValidator {

    private final Separator separator = new Separator();

    private final MatcherUtils matcherUtils = new MatcherUtils();

    public void validateInput(String carNames, long raceCount) {

        validateByRegex(carNames);

        validateCarNameLength(carNames);

//        validateCarNameContainsWhitespace(carNames);

        validateRaceCount(raceCount);

    }

    private void validateByRegex(String carNames) {
        if (matcherUtils.isMatched(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLength(String carNames) {

        String[] separatedCarNames = separator.separate(carNames);

        if (separatedCarNames.length == SINGLE_ELEMENT.value()) {
            throw new IllegalArgumentException();
        }

        Stream.of(separatedCarNames)
                .forEach(carName -> {
                    if (biggerThanLimit(carName)) {
                        throw new IllegalArgumentException();
                    }
                });
    }
    
    private void validateRaceCount(long raceCount) {
        if (raceCount < MIN_RACE_COUNT.value()) {
            throw new IllegalArgumentException();
        }
    }


    private boolean biggerThanLimit(String carName) {
        return carName.length() > LENGTH_LIMIT.value();
    }
}
