package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.exceptions.ValidateError;

public class InputView {
    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static int inputTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        ValidateError.validateTryNumber(input);
        return Integer.parseInt(input);
    }
}
