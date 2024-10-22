package racingcar;

import java.util.*;

public class Car {

    public List<String> getCarNames(String input) {
        validateInput(input);
        List<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        validateCarNamesDuplicated(carNames);
        return carNames;
    }

    private void validateInput(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNamesDuplicated(List<String> carNames) {
        Set<String> checkDuplicatedCarNames = new HashSet<>(carNames);
        if (checkDuplicatedCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException();
        }
    }
}
