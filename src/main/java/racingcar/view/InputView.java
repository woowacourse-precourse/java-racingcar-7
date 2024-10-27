package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String inputNames() {
        return readLine();
    }

    public int inputGameCnt() {
        return Integer.parseInt(readLine());
    }
}
