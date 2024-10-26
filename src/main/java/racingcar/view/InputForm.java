package racingcar.view;

import java.util.Arrays;
import java.util.List;

public class InputForm {
    private String inputNames;
    private List<String> names;
    private int roundCount;

    public InputForm(String inputNames, int roundCount) {
        this.inputNames = inputNames;
        this.names = Arrays.stream(inputNames.split(",")).toList();
        this.roundCount = roundCount;
    }

    public String getInputNames() {
        return inputNames;
    }

    public List<String> getNames() {
        return names;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
