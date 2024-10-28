package racingcar.ui;

import static racingcar.ui.validator.InputValidator.validateCarNames;
import static racingcar.ui.validator.InputValidator.validatePositiveNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public String input() {
        return Console.readLine().stripTrailing();
    }

    public List<String> showGetCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseCarNames(input());
    }

    private List<String> parseCarNames(String carNamesInput) {
        List<String> carNames = convertStringToList(carNamesInput.split(","));
        validateCarNames(carNames);

        return carNames;
    }

    private List<String> convertStringToList(String[] splitNames) {
        return Arrays.asList(splitNames);
    }
    public int showGetFinalRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        int finalRound = parseFinalRound();
        validatePositiveNumber(finalRound);

        return finalRound;
    }

    private int parseFinalRound() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}
