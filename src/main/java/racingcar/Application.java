package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.GameDirector;
import racingcar.util.InputHandler;
import racingcar.util.OutputHandler;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputHandler.readCarNames();
        int circleCount = InputHandler.readAttemptCount();
        OutputHandler.printResultMessage();

        GameDirector gameDirector = new GameDirector(carNames, circleCount);
        gameDirector.run();
        Console.close();
    }
}
