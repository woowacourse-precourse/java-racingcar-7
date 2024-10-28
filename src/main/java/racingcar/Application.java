package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing(
                new Input(),
                new Output()
        );

        racing.run();
    }
}
