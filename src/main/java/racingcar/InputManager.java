package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public String inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String inputNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }
}
