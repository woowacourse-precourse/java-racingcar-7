package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {
    public static String InputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        Validator.checkCarNamesNotEmpty(carNames);

        return Console.readLine();
    }

    public static int InputRoundNumber() {
        String roundCountInput = Console.readLine();
        int roundCount = Validator.parseRoundCount(roundCountInput);
        Validator.checkRoundCountPositive(roundCount);
        return roundCount;
    }
}
