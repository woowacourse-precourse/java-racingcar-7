package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TURN_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String DELIMITER = ",";

    public List<String> inputCarName() {
        DisplayInputPrompt(INPUT_CAR_MESSAGE);
        String carNamePart = readUserInput();
        final List<String> carNames = parseCarNames(carNamePart);
        validateCarName(carNames);

        return carNames;
    }

    public int inputRacingTurn() {
        DisplayInputPrompt(INPUT_TURN_MESSAGE);
        String rawTurn = readUserInput();
        validateTurn(rawTurn);

        return parseTurn(rawTurn);
    }

    private String readUserInput() {
        return Console.readLine();
    }

    private void DisplayInputPrompt(String prompt) {
        System.out.println(prompt);
    }

    private List<String> parseCarNames(String carNamePart) {
        return List.of(carNamePart.split(DELIMITER));
    }

    private void validateCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateTurn(String rawTurn) {
        for (char digit : rawTurn.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int parseTurn(String rawTurn) {
        try {
            return Integer.parseInt(rawTurn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
