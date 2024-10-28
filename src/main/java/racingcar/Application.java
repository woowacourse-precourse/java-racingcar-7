package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.Car;
import racingcar.game.GameDirector;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        String carNames = InputHandler.readCarNames();
        String count = InputHandler.readAttemptCount();
        OutputHandler.printResultMessage();

        GameDirector gameDirector = new GameDirector(carNames, count);
        List<Car> matchResult = gameDirector.run();
        gameDirector.printWinner(matchResult);

        Console.close();
    }
}
