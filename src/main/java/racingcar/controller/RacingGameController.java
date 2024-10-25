package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.Car;
import racingcar.service.RacingGameService;
import racingcar.validation.RaceCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outPutView;
    private final RaceCountValidator raceCountValidator;

    public RacingGameController(RacingGameService racingGameService, InputView inputView, OutputView outputView,
                                RaceCountValidator raceCountValidator) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outPutView = outputView;
        this.raceCountValidator = raceCountValidator;
    }

    public void run() {

        String carNames = inputView.getCarNamesFormView();
        List<Car> racingCars = racingGameService.splitAndInitializeRacingCars(carNames);

        String raceCount = inputView.getRaceCountFormView();
        raceCountValidator.validate(raceCount);

        runCarRaceAndPrintResults(Integer.valueOf(raceCount), racingCars);
        findWinnersAndPrintResults(racingCars);
    }

    private void runCarRaceAndPrintResults(Integer raceCount, List<Car> racingCars) {

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < raceCount; i++) {
            racingGameService.startCarRaceGame(racingCars);

            for (Car car : racingCars) {
                outPutView.printCarRaceGameResults(car.getName(), "-".repeat(car.getDistance()));
            }

            System.out.println();
        }
    }

    private void findWinnersAndPrintResults(List<Car> racingCars) {
        Integer maxDistance = getMaxDistance(racingCars);

        List<String> winnerCars = getWinners(racingCars, maxDistance);
        String winners = String.join(", ", winnerCars);
        outPutView.printWinners(winners);
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
