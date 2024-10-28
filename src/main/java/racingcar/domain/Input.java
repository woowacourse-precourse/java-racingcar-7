package racingcar.domain;

import java.lang.reflect.Type;
import racingcar.view.constant.Request;

public class Input {

    private String request;
    private final String input;
//    private final Type type;

    public Input(String input) {
        this.input = input;
    }

    public Input(String request, String input) {
        this.request = request;
        this.input = input;
//        type = input.getClass();
    }

    public String getInput() {
        return input;
    }

    public String getRequest() {
        return request;
    }
//
//    public Type getType() {
//        return type;
//    }
}
