package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.CarsNameParser;
import racingcar.model.InputValidator;
import racingcar.view.RaceView;
import racingcar.view.SystemView;

import java.util.Set;

public class RacingGameController {
    private final SystemView systemView;
    private final RaceView raceView;
    private final CarsNameParser carsNameParser;

    public RacingGameController() {
        this.systemView = new SystemView();
        this.raceView = new RaceView();
        this.carsNameParser = new CarsNameParser();
    }

    public void run() {
        try {
            String nameInput = systemView.printSystemNameInputMessage();
            Set<String> carNames = carsNameParser.parse(nameInput);

            Cars cars = new Cars(carNames);
            cars.registerObserver(raceView);

            String trialInput = systemView.printSystemInputTrialMessage();
            InputValidator.validateTrialInput(trialInput);

            systemView.printSystemRaceStartMessage();
            cars.repeatGo(Integer.parseInt(trialInput));

            systemView.printSystemWinneMessage();
            raceView.displayWinner();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
