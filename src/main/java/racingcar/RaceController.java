package racingcar;

import java.util.List;

public class RaceController {
    private RaceGame game;
    private RaceView view;

    public RaceController(RaceView view){
        this.view = view;
    }
    public void startGame(){
        initializeGame();
        playGame();
        displayResults();
    }
    private void initializeGame(){
        List<String> carNames = view.getCarNames();
        int totalRounds = view.getTotalRounds();
        this.game = new RaceGame(carNames, totalRounds, view);
    }
    private void playGame(){
        game.playRounds();
        view.displayRoundResults(game.getCars());
    }
    private void displayResults(){
        List<Car> winners = game.getWinners();
        view.displayWinners(winners);
    }
}
