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

    public String getInput() {
        return readLine();
    }

    public List<String> getCarnames(String inputData) {
        return List.of(inputData.split(COMMA));
    }

    public Integer getTotalRound(String inputData) {
        return Integer.parseInt(inputData);
    }
}
