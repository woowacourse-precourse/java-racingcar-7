package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.InputConsoleHandler;
import racingcar.io.OutputConsoleHandler;
import racingcar.provider.NumberProvider;
import racingcar.provider.RandomNumberProvider;

public class Application {
    public static void main(String[] args) {
        NumberProvider numberProvider = new RandomNumberProvider();
        InputConsoleHandler inputConsoleHandler = new InputConsoleHandler();
        OutputConsoleHandler outputConsoleHandler = new OutputConsoleHandler();

        try {
            RacingGame racingGame = new RacingGame(numberProvider, inputConsoleHandler, outputConsoleHandler);
            racingGame.runGame();
        } finally {
            Console.close();
        }
    }
}
