package racingcar.domain;

import java.lang.reflect.Type;

public class Input {

    private final String input;
//    private final Type type;

    public Input(String input) {
        this.input = input;
//        type = input.getClass();
    }

    public String getInput() {
        return input;
    }
//
//    public Type getType() {
//        return type;
//    }
}
