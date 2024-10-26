package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGameMaxRound;
import racingcar.service.RacingGameService;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    private final RacingGameService racingGameService = new RacingGameService();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
        String carNames = racingGameInputView.getUserInput();
        List<Car> cars = racingGameService.createCars(carNames);

        racingGameOutputView.printRacingGameRoundInputMessage();
        RacingGameMaxRound gameRound = new RacingGameMaxRound(racingGameInputView.getUserInput());
    }
}
