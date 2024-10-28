package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;

public class RacingGameService {
    private RacingGame racingGame;

    public void startGame(String carNames, int rounds) {
        validateCarNames(carNames);
        validateRounds(rounds);

        List<Car> cars = createCars(carNames);
        racingGame = new RacingGame(cars, rounds);
    }

    public void playRound() {
        racingGame.playRound();
    }

    public boolean hasNextRound() {
        return racingGame.hasNextRound();
    }

    public List<Car> getCurrentStatus() {
        return racingGame.getCars();
    }

    public List<String> getWinners() {
        return racingGame.getWinners();
    }

    // Private helper methods for validation and creation
    private void validateCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            String trimmedName = carName.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("라운드는 1 이상이어야 합니다.");
        }
    }

    private List<Car> createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameArray) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }
}
