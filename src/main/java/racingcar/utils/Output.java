package racingcar.utils;

public class Output {

    private final StringBuilder value;

    public Output() {
        this.value = new StringBuilder();
    }

    public void append(String value) {
        this.value.append(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
