package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.utils.CarNameValidator;
import racingcar.utils.RaceRoundsValidator;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView;
    private final CarNameValidator carNameValidator;
    private final RaceRoundsValidator raceRoundsValidator;

    public GameController() {
        this.inputView = new InputView();
        this.carNameValidator = new CarNameValidator();
        this.raceRoundsValidator = new RaceRoundsValidator();
    }

    public void startGame() {
        String carNames = inputView.inputCarNames();
        List<Car> cars = carNameValidator.processCarName(carNames);
        String raceRounds = inputView.inputRaceRounds();
        int validRaceRounds = raceRoundsValidator.validateRoundsInput(raceRounds);

        Race race = new Race(cars, validRaceRounds);
        race.startRace();
    }
}
