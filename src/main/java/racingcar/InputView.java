package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public ConsoleInput ask() {
        String carNames = askCarNames();
        String tryCount = askTryCount();
        Console.close();
        return new ConsoleInput(carNames, tryCount);
    }

    private String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private String askTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}

