package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;
import java.util.List;

public class InputView {
    private static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT_ROUND_COUNT = "시도할 라운드 횟수는 몇 회인가요?";

    public List<String> getUserInput() {
        System.out.println(PROMPT_CAR_NAMES);
        return Validator.validateCarNames(Console.readLine());
    }

    public int getUserInputAsInt() {
        System.out.println(PROMPT_ROUND_COUNT);
        String input = Console.readLine();
        System.out.println();
        return Validator.validateRoundCount(input);
    }
}
