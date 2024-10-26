package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class RacingGameController {

    public static void game() {
        List<String> carNames = InputView.getCars();
        validateName(carNames);

        int round = validateRound(InputView.getRounds());

    }

    private static void validateName(List<String> carNames) {
        checkDuplicateNames(carNames);
        carNames.forEach(RacingGameController::checkNameFormat);
        carNames.forEach(RacingGameController::checkNameLength);
    }

    private static void checkDuplicateNames(List<String> carNames) {
        List<String> distinctValidateCarName = carNames
                .stream()
                .distinct()
                .toList();

        if (distinctValidateCarName.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameFormat(String carName) {
        if(!carName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("자동차의 이름은 알파벳이어야 합니다.");
        }
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    private static int validateRound(String round) {
        checkIsNumeric(round);
        checkRoundPositive(parseRound(round));
    }
    private static void checkIsNumeric(String round) {
        if (!round.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
    private static void checkRoundPositive(int roundNum) {
        if (roundNum < 1) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }
    }

    private static int parseRound(String round) {
        return Integer.parseInt(round);
    }
}
