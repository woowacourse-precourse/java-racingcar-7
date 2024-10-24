package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingInputView {
    public String RacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int RacingRoundCount() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Integer.parseInt(Console.readLine());
    }

}


