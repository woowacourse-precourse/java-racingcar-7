package racingcar;

import java.util.List;

public class RaceController {
    private final RaceService raceService;
    private final RaceView raceView;
    private final InputValidator validator;

    public RaceController(RaceService raceService, RaceView raceView, InputValidator validator) {
        this.raceService = raceService;
        this.raceView = raceView;
        this.validator = validator;
    }

    public void startGame() throws IllegalArgumentException {

        String carNamesInput = raceView.inputCarNames();
        List<String> carNames = validator.validateCarNames(carNamesInput);
        Race race = raceService.initializeRace(carNames);
        String roundsInput = raceView.inputRounds();
        validator.validateRounds(roundsInput);
        int rounds = Integer.parseInt(roundsInput);

        for (int i = 0; i < rounds; i++) {
            race.raceOnce();
            raceView.printRaceProgress(race.getCars());
        }

        List<Car> winners = race.getWinners();
        raceView.printWinners(winners);

    }
}
