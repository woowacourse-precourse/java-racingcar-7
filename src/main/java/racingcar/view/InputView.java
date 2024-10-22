package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.Validator;

public class InputView {

    public String getCarName() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAME);
        return Console.readLine();
    }

    public long getTryNumber() {
        System.out.println(ConsoleMessage.ENTER_TRY_NUMBER);
        return Validator.isNumeric(Console.readLine());
    }

    public void close() {
        Console.close();
    }
}
