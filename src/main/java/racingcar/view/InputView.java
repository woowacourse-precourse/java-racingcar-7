package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String inputCarNames() {
        return readLine();
    }

    public int inputTryCount() {
        return Integer.parseInt(readLine());
    }
}
