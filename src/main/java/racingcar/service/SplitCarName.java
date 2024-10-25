package racingcar.service;

import java.util.List;

public class SplitCarName {
    private static final String COMMA = ",";
    private final List<String> splitCarNameGroup;

    public SplitCarName(String carNameGroup) {
        this.splitCarNameGroup = splitCarNameWithComma(carNameGroup);
    }

    private List<String> splitCarNameWithComma(String carNameGroup) {
        return List.of(carNameGroup.split(COMMA));
    }

    public List<String> getSplitCarNameGroup() {
        return splitCarNameGroup;
    }
}
