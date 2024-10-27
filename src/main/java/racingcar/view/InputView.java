package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String carNames() {
        System.out.println(INPUT_CARS_NAME);
        return read();
    }

    private static String read() {
        return readLine();
    }
}
