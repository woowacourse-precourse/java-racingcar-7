package racingcar.ui;

public class Input {
    private final String[] names;
    private final int tryCount;

    public Input(String[] names, int tryCount) {
        this.names = names;
        this.tryCount = tryCount;
    }


    public String[] getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }


}
