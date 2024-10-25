package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Car;
import racingcar.game.GameDirector;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomNumStrategy;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        String carNames = InputHandler.readCarNames();
        String count = InputHandler.readAttemptCount();
        OutputHandler.printResultMessage();

        MoveStrategy strategy = new RandomNumStrategy();
        GameDirector gameDirector = new GameDirector(carNames, count, strategy);
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);

        Console.close();
    }
}
