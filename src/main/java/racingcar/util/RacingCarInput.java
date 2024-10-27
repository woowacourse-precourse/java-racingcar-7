package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarInput {

    public String[] inputCarNames() {

        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public int inputTryCount() {

        System.out.println("시도할 횟수");
        return Integer.parseInt(Console.readLine());
    }
}
