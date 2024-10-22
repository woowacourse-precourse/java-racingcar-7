package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingView {

    // 자동차 이름 입력 받기
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표로 구분)");
        return Console.readLine().trim().split(",");
    }

}
