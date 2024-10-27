package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private InputView() {
    }

    public static String inputNames() {
        return readLine();
    }

    public static int inputGameCnt() {
        return Integer.parseInt(readLine());
    }
}
