package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.Util;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.TrialsCountValidator;


public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIALS_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        new CarNameValidator().validate(input);
        return Arrays.asList(Util.removeSpace(input).split(","));
    }

    public int readTrialsCount() {
        System.out.println(INPUT_TRIALS_COUNT_MESSAGE);
        String input = Console.readLine();
        new TrialsCountValidator().validate(input);
        return Integer.parseInt(input);
    }
}