package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarService racingCarService;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void run() {

        String carNames = racingCarView.getCarNamesFromView();
        Integer numberOfAttempts = racingCarView.getNumberOfAttemptsFromView();

        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        List<Car> racingCars = racingCarService.splitAndInitializeRacingCars(carNames);

        printRaceResults(numberOfAttempts, racingCars);
        printWinners(racingCars);
    }

    private void printRaceResults(Integer numberOfAttempts, List<Car> racingCars) {

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            racingCarService.startRacingCarGame(racingCars);

            for (Car car : racingCars) {
                racingCarView.printRaceResults(car.getName(), "-".repeat(car.getDistance()));
            }
        }
    }

    private void printWinners(List<Car> racingCars) {
        Integer maxDistance = getMaxDistance(racingCars);
    }

    private Integer getMaxDistance(List<Car> racingCars) {

        Integer maxDistance = 0;

        for (Car car : racingCars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        return maxDistance;
    }

    private List<String> getWinners(List<Car> racingCars, Integer maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : racingCars) {
            if (Objects.equals(car.getDistance(), maxDistance)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
