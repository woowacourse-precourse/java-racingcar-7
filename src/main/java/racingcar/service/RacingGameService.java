package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarLocation;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

public class RacingGameService {
    private final RaceProgressService raceProgressService;

    public RacingGameService(RaceProgressService raceProgressService) {
        this.raceProgressService = raceProgressService;
    }

    public RacingGame initializeRace(List<String> carNames, int attempts) {
        List<RacingCar> cars = RacingCar.createRacingCars(carNames);
        return new RacingGame(cars, attempts);
    }

    public List<List<CarLocation>> runRaceRounds(RacingGame racingGame) {
        List<List<CarLocation>> raceHistory = new ArrayList<>();

        for (int i = 0; i < racingGame.attempts(); i++) {
            raceProgressService.moveCarsInRounds(racingGame.cars());
            raceHistory.add(raceProgressService.getCurrentLocations(racingGame.cars()));
        }
        return raceHistory;
    }

    public List<String> getWinners(List<RacingCar> cars) {
        int maxLocation = cars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(RacingCar::getName)
                .toList();
    }
}
