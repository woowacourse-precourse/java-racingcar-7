package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class Game {
    public void start() {
        try {
            Output.CarName();
        } catch(IllegalArgumentException e) {
            Output.Error();
            throw new IllegalArgumentException();
        }
    }
}
