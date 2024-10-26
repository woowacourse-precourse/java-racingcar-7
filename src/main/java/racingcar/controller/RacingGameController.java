package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGameMaxRound;
import racingcar.service.RacingGameSettingService;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameOutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameInputView racingGameInputView = new RacingGameInputView();
    private final RacingGameOutputView racingGameOutputView = new RacingGameOutputView();
    private final RacingGameSettingService racingGameSettingService = new RacingGameSettingService();
    public void startGame(){
        racingGameOutputView.printRacingGameStartingMessage();
        String carNames = racingGameInputView.getUserInput();
        List<Car> cars = racingGameSettingService.createCars(carNames);

        racingGameOutputView.printRacingGameRoundInputMessage();
        String roundInput = racingGameInputView.getUserInput();
        RacingGameMaxRound gameRound = racingGameSettingService.createGameRound(roundInput);
    }
}
