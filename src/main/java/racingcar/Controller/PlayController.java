package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.GameCars;
import racingcar.View.GameView;

public class PlayController {
    private final int gameNumber;
    private final GameCars gameCars;
    private final GameView gameView;

    public PlayController(GameCars gameCars, int gameNumber, GameView gameView) {
        this.gameCars = gameCars;
        this.gameNumber = gameNumber;
        this.gameView = gameView;
    }

    public void startGame() {
        runGameRounds();
        List<Car> winners = determineWinners();
        displayWinners(winners);
    }

    private void runGameRounds() {
        for (int i = 0; i < gameNumber; i++) {
            gameCars.playGames();
            gameView.showGameProgress(gameCars.getCars());
        }
    }

    private List<Car> determineWinners() {
        return gameCars.findWinnerCars();
    }

    private void displayWinners(List<Car> winners) {
        gameView.showWinnerCars(winners);
    }
}
