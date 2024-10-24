package racingcar.input;

import java.util.List;

public class Input {

    private List<String> names;
    private int tryNumber;

    public Input(List<String> names, int tryNumber) {
        names = this.names;
        tryNumber = this.tryNumber;
    }

    public List<String> getNames() {
        return names;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
