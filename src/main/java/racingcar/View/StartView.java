package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class StartView {
    public static String inputCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String inputNumOfMatch() {
        System.out.println("시도할 회수를 입력하세요");
        return Console.readLine();
    }

}