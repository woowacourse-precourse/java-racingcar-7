package racingcar.util;

import java.util.List;

public class Validator {
    public static void validateCarNames(List<String> carNames) {
        checkCarCount(carNames);
        checkDuplicateNames(carNames);
        carNames.forEach(Validator::checkNameFormat);
        carNames.forEach(Validator::checkNameLength);
    }

    private static void checkCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 2개 이상부터 경기가 가능합니다.");
        }
    }

    private static void checkDuplicateNames(List<String> carNames) {
        List<String> distinctCarNames = carNames.stream().distinct().toList();
        if (distinctCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameFormat(String carName) {
        if (!carName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("자동차의 이름은 알파벳이어야 합니다.");
        }
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    public static int validateRound(String round) {
        checkIsNumeric(round);
        int roundNum = parseRound(round);
        checkRoundPositive(roundNum);
        return roundNum;
    }

    private static void checkIsNumeric(String round) {
        if (!round.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static void checkRoundPositive(int roundNum) {
        if (roundNum < 1) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요.");
        }
    }

    private static int parseRound(String round) {
        return Integer.parseInt(round);
    }

}
