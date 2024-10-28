package racingcar.Controller;

import java.util.stream.IntStream;
import racingcar.Model.RacingCars;
import racingcar.View.OutputView;

public class GameController {
    private RacingCars racingCars;
    private int roundNum;

    public GameController(){
        set();
        play();
        showWinner();
    }
    public void set(){
        racingCars = InputController.setRacingCars();
        roundNum = InputController.setRoundNum();
    }
    public void play(){
        OutputView.printSimulationStartMessage();
        IntStream.range(0,roundNum).forEach(i -> racingCars.playRound());
    }
    public void showWinner(){
        racingCars.printWinner();
    }
}
