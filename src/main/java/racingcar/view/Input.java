package racingcar.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private final String COMMA = ",";

    protected Input() {
    }

    public static Input of() {
        return new Input();
    }

    public List<String> getCarnames() {
        System.out.println(InputMessage.자동차_이름_입력);
        return splitCarnames(getInput());
    }

    public Integer getTotalRound() {
        System.out.println(InputMessage.자동차_이름_입력);
        return parserTotalRound(getInput());
    }

    public List<String> splitCarnames(String inputData) {
        return List.of(inputData.split(COMMA));
    }

    public Integer parserTotalRound(String inputData) {
        return Integer.parseInt(inputData);
    }

    public String getInput() {
        return readLine();
    }
}
