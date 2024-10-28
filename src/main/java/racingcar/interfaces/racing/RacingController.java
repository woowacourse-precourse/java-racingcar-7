package racingcar.interfaces.racing;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.racing.JudgeService;
import racingcar.domain.racing.RacingService;
import racingcar.domain.car.CarService;
import racingcar.interfaces.car.CarResponse;
import racingcar.interfaces.car.CarsResponse;
import racingcar.interfaces.input.InputHandler;
import racingcar.interfaces.output.OutputHandler;
import racingcar.interfaces.winner.WinnerResponse;

public class RacingController {

    private final CarService carService;
    private final RacingService racingService;
    private final JudgeService judgeService;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingController(CarService carService, RacingService racingService, JudgeService judgeService, InputHandler inputHandler, OutputHandler outputHandler) {
        this.carService = carService;
        this.racingService = racingService;
        this.judgeService = judgeService;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void processRace() {
        List<String> carNames = inputHandler.getCarNames();
        int raceCount = inputHandler.getRaceCount();

        Cars cars = carService.makeCars(carNames);
        outputHandler.printResultHeader();
        startRace(cars, raceCount);
        printWinner(judgeService.judgeWinner(cars));
    }

    private void startRace(Cars cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            CarsResponse carsResponse = racingService.race(cars);
            printEachRace(carsResponse);
            outputHandler.println();
        }
    }

    private void printEachRace(CarsResponse carsResponse) {
        for (CarResponse carResponse : carsResponse.carResponses()) {
            outputHandler.print(carResponse.carStatus());
        }
    }

    private void printWinner(WinnerResponse winnerResponse) {
        outputHandler.print(winnerResponse.winnerList());
    }
}
