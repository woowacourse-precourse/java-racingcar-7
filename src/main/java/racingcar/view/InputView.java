package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] getUserInitialInputs() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String trialCount = Console.readLine();
        return new String[]{carNames, trialCount};
    }
}
