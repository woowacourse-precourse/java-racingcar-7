package racingcar;

import java.util.List;

public class RaceController {
    private final RaceService raceService;
    private final RaceView raceView;

    public RaceController(RaceService raceService, RaceView raceView) {
        this.raceService = raceService;
        this.raceView = raceView;
    }

    public void startGame() throws IllegalArgumentException {
//        try {
            List<String> carNames = raceView.inputCarNames();
            Race race = raceService.initializeRace(carNames);
            int rounds = raceView.inputRounds();

            raceService.startRace(race, rounds);

            for (int i = 0; i < rounds; i++) {
                race.raceOnce();
                raceView.printRaceProgress(race.getCars());
            }

            List<Car> winners = race.getWinners();
            raceView.printWinners(winners);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
