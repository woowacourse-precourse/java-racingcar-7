package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.racing.RacingManager;

public class AppConfig {
    public Input input() {
        return new Input();
    }

    public Output output() {
        return new Output();
    }

    public RacingManager RacingManager() {
        return new RacingManager(input(), output());
    }
}
