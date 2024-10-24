package racingcar.domain;

public class Input {

    private final String names;

    private Input(String names) {
        this.names = names;
    }

    public static Input from(String text) {
        return new Input(text);
    }

    public String getNames() {
        return names;
    }

}