package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IOController {

    String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        return carNames;
    }

    String enterRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String repeatCount = Console.readLine();

        return repeatCount;
    }


}
