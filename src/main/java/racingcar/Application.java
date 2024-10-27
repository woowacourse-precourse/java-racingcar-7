package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {

        GameView view = new GameView();

        List<Car> cars = parseCars(view.getCarNamesInput());
        int attemptCount = view.getAttemptCountInput();

        Game game = new Game(cars, attemptCount);

        view.displayBeforeGameProcess();

        for (int i = 0; i < game.getAttemptCount(); i++) {
            game.playRound();
            view.displayRoundResult(game.getRoundResult());
        }

        view.displayWinners(game.getWinners());

    }

    private static List<Car> parseCars(List<String> carNamesInput) {
        return carNamesInput.stream()
                            .map(String::trim)
                            .map(Car::new)
                            .toList();
    }
}
