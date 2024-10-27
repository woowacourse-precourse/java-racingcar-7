package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        List<String> carNames = inputReader.readCarNames();
        int tryCount = inputReader.readTryCount();

        Racing racing = new Racing(carNames);
        racing.start(tryCount);

        Winner winner = new Winner();
        winner.printWinner(racing.positions());
    }
}
