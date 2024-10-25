package racingcar.view;

import racingcar.view.io.Input;
import racingcar.view.io.Output;

public class GameView {
    public final Input input;
    public final Output output;

    public GameView() {
        this.input = new Input();
        this.output = new Output();
    }
}
