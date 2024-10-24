package racingcar.Controller;

import racingcar.Model.GameCars;
import racingcar.View.GameView;

public class PlayController {
    public final int gameNumber;
    public final GameCars gameCars;
    public GameView gameView;

    public PlayController() {
        gameCars = InputController.setCars();
        gameNumber = InputController.setGameCount();
        gameView = new GameView(gameCars);
    }
    //여기서 gameNumber대로 돌려야할까 GameCars에 넘겨서 돌려야할까
    public void play(){
        for(int i=gameNumber; i>0; i--){
            gameCars.playGame();
            gameView.showGameProgress();
        }

    }

    public void findWinner(){
        gameView.findWinnerCars();
    }
}
