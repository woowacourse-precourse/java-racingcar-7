package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.ViewMessage.자동차_이름_입력;
import static racingcar.view.ViewMessage.총_라운드_입력;

public class Input {

    private final String COMMA = ",";

    protected Input() {
    }

    public static Input of() {
        return new Input();
    }

    public String getStringCarnames() {
        System.out.println(자동차_이름_입력.getMessage());
        return getInput();
    }

    public String getStringTotalRound() {
        System.out.println(총_라운드_입력.getMessage());
        return getInput();
    }

    private String getInput() {
        return readLine();
    }
}
