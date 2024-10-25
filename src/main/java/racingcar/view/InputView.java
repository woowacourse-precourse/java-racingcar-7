package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.model.Message.CAR_NAMES_MESSAGE;
import static racingcar.model.Message.TRY_NUMBER_MESSAGE;

public class InputView {

    // 입력
    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public static String inputTryNumber() {
        System.out.println(TRY_NUMBER_MESSAGE);
        return Console.readLine();
    }
}