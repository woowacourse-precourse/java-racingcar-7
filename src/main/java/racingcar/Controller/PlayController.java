package racingcar.Controller;

import java.util.List;
import racingcar.Model.Car;
import racingcar.Model.GameCars;
import racingcar.View.GameView;

public class PlayController {
    public final int gameNumber;
    public final GameCars gameCars;
    public GameView gameView;

    public PlayController() {
        gameCars = InputController.setCars();
        gameNumber = InputController.setGameCount();
        gameView = new GameView();
        play();
        findWinner();
        showWinner();
    }



    public void play() {
        for(int i = 0; i < gameNumber; i++) {
            gameCars.playGames();
            gameView.showGameProgress(gameCars.getCars());
        }
    }

    public List<Car> findWinner() {
        return gameCars.findWinnerCars();
    }

    public void showWinner(){
        gameView.showWinnerCars(findWinner());
    }
}
