package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String carNameString;
    private int attemptCount;

    public void inputNameAndAttemptCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNameString = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.attemptCount = Integer.parseInt(Console.readLine());
    }

    public String getCarNameString() {
        return carNameString;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
