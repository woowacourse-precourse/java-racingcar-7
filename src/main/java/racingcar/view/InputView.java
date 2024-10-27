package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return InputParser.parseCarNames(Console.readLine());
    }


    public static int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return InputParser.parseTryCount(Console.readLine());
    }
}
