package racingcar.interfaces.racing;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.racing.JudgeService;
import racingcar.domain.racing.RacingService;
import racingcar.domain.car.CarService;
import racingcar.interfaces.car.CarResponse;
import racingcar.interfaces.car.CarsResponse;
import racingcar.interfaces.output.OutputView;
import racingcar.interfaces.winner.WinnerResponse;

public class RacingController {

    private final CarService carService;
    private final RacingService racingService;
    private final OutputView outputView;
    private final JudgeService judgeService;

    public RacingController(CarService carService, RacingService racingService, OutputView outputView,
                            JudgeService judgeService) {
        this.carService = carService;
        this.racingService = racingService;
        this.outputView = outputView;
        this.judgeService = judgeService;
    }

    public void startRace(List<String> carNames, int raceCount) {
        Cars cars = carService.makeCars(carNames);
        raceEachRound(cars, raceCount);
        printWinner(judgeService.judgeWinner(cars));
    }

    private void raceEachRound(Cars cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            CarsResponse carsResponse = racingService.race(cars);
            printCarsResponse(carsResponse);
            outputView.println();
        }
    }

    private void printCarsResponse(CarsResponse carsResponse) {
        for (CarResponse carResponse : carsResponse.carResponses()) {
            outputView.print(carResponse.carStatus());
        }
    }

    private void printWinner(WinnerResponse winnerResponse) {
        outputView.print(winnerResponse.winnerList());
    }
}

