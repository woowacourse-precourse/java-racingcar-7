package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.Movement;
import racingcar.dto.CarLocation;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

public class RacingGameService {
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    public RacingGame initializeRace(List<String> carNames, int attempts) {
        List<RacingCar> cars = RacingCar.createRacingCars(carNames);
        return new RacingGame(cars, attempts);
    }

    public List<List<CarLocation>> runRace(RacingGame racingGame) {
        List<List<CarLocation>> raceHistory = new ArrayList<>();

        for (int i = 0; i < racingGame.attempts(); i++) {
            raceRound(racingGame.cars());
            raceHistory.add(getCurrentLocations(racingGame.cars()));
        }
        return raceHistory;
    }

    private void raceRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            Movement movement = determineMovement(randomValue);
            car.move(movement);
        });
    }

    private Movement determineMovement(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            return Movement.MOVING_FORWARD;
        } else {
            return Movement.STOP;
        }
    }

    private List<CarLocation> getCurrentLocations(List<RacingCar> cars) {
        return cars.stream()
                .map(car -> new CarLocation(car.getName(), car.getLocation()))
                .toList();
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
