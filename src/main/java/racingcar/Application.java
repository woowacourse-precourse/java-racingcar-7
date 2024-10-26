package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Car;
import racingcar.game.GameDirector;
import racingcar.strategy.Condition;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        String carNames = InputHandler.readCarNames();
        String count = InputHandler.readAttemptCount();
        OutputHandler.printResultMessage();

        Condition condition = Condition.getCondition();
        GameDirector gameDirector = new GameDirector(carNames, count, condition);
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);

        Console.close();
    }
}
