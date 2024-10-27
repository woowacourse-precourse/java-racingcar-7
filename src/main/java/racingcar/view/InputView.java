package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;

public class InputView {

    public String inputRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int inputGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String gameCount = Console.readLine();

        try {
            return Integer.parseInt(gameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_VALID_NUMBER.getMessage());
        }
    }
}
