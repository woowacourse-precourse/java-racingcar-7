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

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarService carService;
    private final RacingService racingService;
    private final JudgeService judgeService;

    public RacingController(CarService carService, RacingService racingService, InputHandler inputHandler,
                            OutputHandler outputHandler,
                            JudgeService judgeService) {
        this.carService = carService;
        this.racingService = racingService;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.judgeService = judgeService;
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
            printCarsResponse(carsResponse);
            outputHandler.println();
        }
    }

    private void printCarsResponse(CarsResponse carsResponse) {
        for (CarResponse carResponse : carsResponse.carResponses()) {
            outputHandler.print(carResponse.carStatus());
        }
    }

    private void printWinner(WinnerResponse winnerResponse) {
        outputHandler.print(winnerResponse.winnerList());
    }
}

