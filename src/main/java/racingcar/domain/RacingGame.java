package racingcar.domain;

import static racingcar.view.constants.ViewMessage.RACE_RESULT_TITLE;
import static racingcar.view.constants.ViewMessage.RACE_STATUS;

import java.util.List;
import racingcar.common.RandomNumber;

public class RacingGame {

    private final List<Car> cars;
    private final RacingGameRound gameRound;

    public RacingGame(final List<Car> cars, final Integer gameRound) {
        this.cars = cars;
        this.gameRound = new RacingGameRound(gameRound);
    }

    public void play() {
        Integer round = gameRound.getRound();

        for (int i = 0; i < round; i++) {
            raceRound();
        }
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            String carName = car.getName();
            Integer distance = car.getDistance();
            String raceStatus = String.format(RACE_STATUS.getMessage(), carName, "-".repeat(distance));

            System.out.println(raceStatus);
        }
        System.out.println();
    }

    private void raceRound() {
        System.out.println(RACE_RESULT_TITLE.getMessage());

        for (Car car : cars) {
            int randomNumber = RandomNumber.pick();
            car.forward(randomNumber);
        }
        printRaceStatus();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }
}
