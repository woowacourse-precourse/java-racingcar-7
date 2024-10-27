package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public String getCarsName() {
        return Console.readLine();
    }

    public int getTryingNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
