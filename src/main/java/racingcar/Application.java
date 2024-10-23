package racingcar;

import racingcar.view.InputReader;

public class Application {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        final String[] carNames = reader.readCarNames();
        final int tryCount = reader.readTryCount();
    }
}
