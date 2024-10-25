package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME);
        return readInput();
    }

    public static String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return readInput();
    }

    public static String readInput() {
        return readLine();
    }
}
