package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<String> carNames = inputHandler.getCarNames();
        inputHandler.areAllCarNameLengthsValid(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        int moveCount = inputHandler.getMoveCount();

        WinnerManager winnerManager = new WinnerManager();
        RacingGame racingGame = new RacingGame(cars, moveCount, winnerManager);

        racingGame.playGame();

        racingGame.announceWinners();
    }
}
