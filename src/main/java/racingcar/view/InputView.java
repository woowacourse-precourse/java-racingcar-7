package racingcar.view;


import static racingcar.validator.Validator.checkBlank;
import static racingcar.validator.Validator.checkDuplicate;
import static racingcar.validator.Validator.checkMaxLength;
import static racingcar.validator.Validator.checkOnlyRest;
import static racingcar.validator.Validator.checkPositive;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<String> readPlayerNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        checkBlank(userInput);
        List<String> playerNames = List.of(userInput.split(","));
        validate(playerNames);
        return playerNames;
    }

    public Integer readTurnFromInput() {
        final int turn;
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String userInput = Console.readLine();

        turn = parseInt(userInput);
        checkPositive(turn);
        return turn;
    }

    private int parseInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 허용되지 않습니다.");
        }
    }

    private void validate(List<String> playerNames) {
        checkOnlyRest(playerNames);
        checkMaxLength(playerNames);
        checkDuplicate(playerNames);
    }
}
