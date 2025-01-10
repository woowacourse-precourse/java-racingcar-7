package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().trim();
    }

    public String inputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요? (최대 10억까지 가능)");
        return Console.readLine().trim();
    }

}
