package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputConsole {
    void run(){
        String carNames = readCarsInput();
        Cars.createCarsFrom(carNames);

        String tryCountInput = readTryCountInput();
        RacingGameCount racingCount = new RacingGameCount(tryCountInput);
    }

    private String readCarsInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    private String readTryCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }
}
