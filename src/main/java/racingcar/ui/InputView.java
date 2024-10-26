package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final int MAXIMUM_CAR_SIZE = 100;
    private static final int MINIMUM_ROUND = 1;
    private static final int MAXIMUM_ROUND = 500;

    public List<String> showGetCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseCarNames(Console.readLine());
    }

    private List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = convertStringToList(carNamesInput.split(","));
        validateCarNames(carNames);

        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        validateCarNamesSize(carNames);
        validateNoWhitespace(carNames);
    }

    private void validateCarNamesSize(List<String> carNames) {
        if (carNames.isEmpty() || carNames.size() > MAXIMUM_CAR_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> convertStringToList(String[] splitNames) {
        return Arrays.asList(splitNames); // 무결성 보장
    }

    private void validateNoWhitespace(List<String> carNames) {
        if (containsWhitespace(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean containsWhitespace(List<String> splitNames) {
        return splitNames.stream()
                .anyMatch(name -> name.length() != name.trim().length());
    }

    public int showGetFinalRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        int finalRound = parseFinalRound();
        validatePositiveNumber(finalRound);

        return finalRound;
    }

    private void validatePositiveNumber(int finalRound) {
        if (finalRound < MINIMUM_ROUND || finalRound > MAXIMUM_ROUND) {
            throw new IllegalArgumentException();
        }
    }

    private int parseFinalRound() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
