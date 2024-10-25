package racingcar.controller;

import racingcar.model.Racing;
import racingcar.view.OutputView;

public class GameController {
    private Racing racing;
    private int roundNumber;

    public GameController() {
        set();
        OutputView.roundStart();
        game();
    }

    public void set() {
        racing = InputController.setRacingCars();
        roundNumber = InputController.setRoundNumber();
    }

    public void game(){
        for(int i = 0; i < roundNumber; i++){
            racing.round();
            OutputView.roundOutput(racing.getCars());
        }
    }
}
