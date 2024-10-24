package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String askForCarNames() {
        return readLine();
    }

    public int askForNumberOfRounds() {
        return Integer.parseInt(readLine());
    }
}
