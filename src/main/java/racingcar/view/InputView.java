package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;

public class InputView {

    public String readCarString() {
        String carString = Console.readLine();
        if (carString == null) {
            throw new IllegalArgumentException();
        }
        return carString;
    }
}
