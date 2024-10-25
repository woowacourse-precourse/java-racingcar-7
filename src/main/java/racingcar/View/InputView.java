package racingcar.View;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String getCarNameInput() {
        System.out.println(CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public String getNumberOfAttemptsInput() {
        System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
        return Console.readLine();
    }

}
