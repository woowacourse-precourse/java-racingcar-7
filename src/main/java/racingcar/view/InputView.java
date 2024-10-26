package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.InputMessage.*;

public class InputView {
    public String[] inputNames() {
        System.out.println(NAMES.getMessage());
        return readLine().split(",");
    }

    public int inputTimes() {
        System.out.println(TIMES.getMessage());
        return Integer.parseInt(readLine());
    }
}
