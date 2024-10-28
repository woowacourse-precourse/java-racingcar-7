package racingcar.domain;

public class Progress {

    private final String value;

    public Progress(String value) {
        this.value = value;
    }

    public Progress addStep(String step) {
        return new Progress(this.value + step);
    }

    public String getValue() {
        return value;
    }
}
