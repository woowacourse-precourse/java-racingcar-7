package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.global.enums.PrintMessage;
import racingcar.global.util.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.view.OutputView;

public class RacingCarService {
    private final OutputView outputView = OutputView.getInstance();
    private final RandomNumberGenerator randomGenerator = RandomNumberGenerator.getInstance();

    public void raceStart(Race race) {
        outputView.printMessage(PrintMessage.GAME_MESSAGE);
        runRace(race);
        announceWinner(race.getCars());
    }

    public void runRace(Race race) {
        Cars cars = race.getCars();
        Integer raceCount = race.getRaceCount();

        for (int count = 0; count < raceCount; count++) {
            moveCars(cars);
            outputView.printGameResult(cars);
        }
    }

    public void moveCars(Cars cars) {
        cars.getCarList().forEach(this::moveCar);
    }

    public void moveCar(Car car) {
        car.increaseDistance(randomGenerator.generator());
    }


    public void announceWinner(Cars cars) {
        List<String> winnerList = findWinner(cars);

        outputView.printWinner(formatWinners(winnerList));
    }

    private List<String> findWinner(Cars cars) {
        Integer maxDistance = findMaxDistance(cars);
        return filterCarsByDistance(cars, maxDistance);
    }

    private Integer findMaxDistance(Cars cars) {
        return cars.getCarList().stream().map(Car::getDistance)
                .max(Integer::compare).orElse(0);
    }

    private List<String> filterCarsByDistance(Cars cars, Integer maxDistance) {
        List<String> winners = new ArrayList<>();

        for (Car car : cars.getCarList()) {
            if (car.getDistance().equals(maxDistance)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private String formatWinners(List<String> carList) {
        return String.join(", ", carList);
    }

}
