package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.InputMessage.*;

public class InputView {
    public String[] inputNames() {
        System.out.println(INPUT_NAMES.getMessage());
        return readLine().split(",");
    }

    public int inputTimes() {
        System.out.println(INPUT_TIMES.getMessage());
        return Integer.parseInt(readLine());
    }
}
