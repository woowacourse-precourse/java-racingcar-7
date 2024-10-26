package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.exception.ExceptionMessage.*;

public class InputView {

    public String carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int tryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT, e);
        }
    }
}
