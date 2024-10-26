package racingcar.ui;

import java.util.List;

public class Input {
    private final List<String> names;
    private final int tryCount;

    public Input(List<String> names, int tryCount) {
        this.names = names;
        this.tryCount = tryCount;
    }


    public List<String> getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }


}
