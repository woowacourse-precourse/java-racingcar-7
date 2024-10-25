package racingcar.domain;

public class Input {
    private String names;
    private int count;

    public Input(String names, int count) {
        this.names = names;
        this.count = count;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setCount(int number) {
        this.count = number;
    }

    public String getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
