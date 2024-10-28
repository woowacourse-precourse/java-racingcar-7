package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameConfigParser {
    private static void validateNameLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
    private static void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름으로 공백은 허용되지 않습니다.");
        }
    }
    private static void validateNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("반드시 하나 이상의 자동차 이름이 필요합니다.");
        }
    }

    private static void validateSameName(List<String> names) {
        Set set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("같은 이름은 포함되면 안됩니다.");
        }
    }

    public static List<String> parseCarNames(String input) {
        String [] splited = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splited) {
            validateBlankName(name);
            validateNameLength(name);
            carNames.add(name);
        }
        validateNames(carNames);
        validateSameName(carNames);
        return carNames;
    }

    public static int parseNumberOfTurn(String input) {
        int numberOfTurn = Integer.parseInt(input);
        if (numberOfTurn < 0) {
            throw new IllegalArgumentException("시도 횟수는 음수여선 안됩니다.");
        }
        return numberOfTurn;
    }
}
