package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {

    public static String promptInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static Long promptInputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputTryCount = Console.readLine();
        InputValidator.validateTryCount(inputTryCount);
        return Long.valueOf(inputTryCount);
    }

    public static void close() {
        Console.close();
    }
}
