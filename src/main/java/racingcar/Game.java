package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class Game {
    public void start() {
        try {
            input();
        } catch(IllegalArgumentException e) {
            Output.error();
            throw new IllegalArgumentException();
        }
    }

    public void input() {
        Output.carName();
    }
}
