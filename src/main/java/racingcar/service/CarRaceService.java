package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.validation.CarValidation.*;
import static racingcar.view.OutputView.*;

public class CarRaceService {

    private RacingGame raceGame;

    public void init(String carNamesInput, String gameMatchesInput) {
        Cars cars = CarNameFormatter.formatCarNames(carNamesInput);
        Integer gameMatches = gameMatchesValid(gameMatchesInput);
        raceGame = new RacingGame(cars, gameMatches);
    }

    public void playGame() {
        Cars cars = raceGame.getCars();
        Integer gameMatches = raceGame.getGameMatches();

        printGameStartMessage();
    }


}
