package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(CAR_NAME_INPUT_PROMPT);
        String input = Console.readLine();
        return parseToStrings(input);
    }

    public String readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_PROMPT);
        return Console.readLine();
    }

    private static List<String> parseToStrings(String input) {
        String[] splitInput = input.split(DELIMITER);
        return List.of(splitInput);
    }
}
