package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public ConsoleInput ask() {
        String carNames = askCarNames();
        String tryCount = askTryCount();
        Console.close();
        return new ConsoleInput(carNames, tryCount);
    }

    private String askCarNames() {
        System.out.println(ASK_CAR_NAMES);
        return Console.readLine();
    }

    private String askTryCount() {
        System.out.println(ASK_TRY_COUNT);
        return Console.readLine();
    }
}

