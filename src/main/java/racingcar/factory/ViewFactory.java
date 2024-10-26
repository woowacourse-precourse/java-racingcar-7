package racingcar.factory;

import racingcar.observer.RuntimeView;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.View;

public class ViewFactory {

    public static final String TYPE_INPUT = "Input";
    public static final String TYPE_RUNTIME = "Runtime";
    public static final String TYPE_OUTPUT = "Output";


    public View create(String type) {
        return switch (type) {
            case TYPE_INPUT -> new InputView();
            case TYPE_RUNTIME -> new RuntimeView();
            case TYPE_OUTPUT -> new OutputView();
            default -> throw new IllegalArgumentException();
        };
    }
}
