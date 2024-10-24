package racingcar.domain;

import java.util.List;

public class Input {

    private final List<String> names;
    private final int tryNumber;

    public Input(List<String> names, int tryNumber) {
        this.names = names;
        this.tryNumber = tryNumber;
    }

    public List<String> getNames() {
        return names;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
