package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
    public String getInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }

    public String getInputTrialNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
