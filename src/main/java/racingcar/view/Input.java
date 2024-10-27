package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static String getCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String inputCarName() {
        System.out.println(getCarNameMessage);
        return Console.readLine();
    }
}
