package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Validation {

    private static Validation instance;

    private Validation() {

    }

    public static Validation getInstance() {
        if (instance == null) {
            instance = new Validation();
        }
        return instance;
    }

    public static final String carNameDivider = ",";

    /**
     * 경주할 자동차 이름 입력 확인 메서드
     *
     * @param input
     */
    public List<String> validateCarNameInput(String input) {

        if (input.startsWith(carNameDivider) || input.endsWith(carNameDivider)) {
            throw new IllegalArgumentException("misplaced of comma");
        }

        List<String> carNameList = Arrays.stream(input.split(carNameDivider)).toList();

        for (String carName : carNameList) {
            validateCarName(carName);
        }

        return carNameList;

    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName == null) {
            throw new IllegalArgumentException("misplaced of comma");
        }

        if (carName.length() > 5) {
            throw new IllegalArgumentException("car name length over 5");
        }
    }

    public int validateRoundCount(String roundCountString) {
        int roundCount;

        try {
            roundCount = Integer.valueOf(roundCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("round count input is not number");
        }

        if (roundCount <= 0 || roundCount > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("wrong round count range");
        }

        return roundCount;
    }

}
