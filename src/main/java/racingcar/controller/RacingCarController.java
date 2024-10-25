package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.RacingCarService;
import racingcar.view.InputHandler;
import camp.nextstep.edu.missionutils.Console;
import racingcar.view.OutputHandler;

import java.util.List;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void RunRacingGame() {
        InputHandler.promptForCarNames();
        String carNames = Console.readLine();
        InputHandler.promptForAttemptCount();
        String countString = Console.readLine();
        InputHandler.validateAttemptCount(countString);
        int attemptCount = Integer.parseInt(countString);

        List<Car> cars = Car.createCars(carNames);
        Race race = new Race(cars);

        racingCarService.startRace(race, attemptCount);

        List<String> winners = racingCarService.getWinners(race.getCars());

        OutputHandler.printWinners(winners);

    }
}
