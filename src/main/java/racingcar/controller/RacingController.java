package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.service.RacingService;
import racingcar.service.WinnerService;
import racingcar.view.CarInputView;
import racingcar.view.RaceOutputView;
import racingcar.view.NumberInputView;
import racingcar.view.WinnersOutputView;

public class RacingController {
    private final CarService carService;
    private final RacingService racingService;
    private final WinnerService winnerService;

    private final CarInputView carInputView;
    private final NumberInputView numberInputView;
    private final RaceOutputView raceOutputView;
    private final WinnersOutputView winnersOutputView;

    public RacingController(
            CarService carService,
            RacingService racingService,
            WinnerService winnerService,
            CarInputView carInputView,
            NumberInputView numberInputView,
            RaceOutputView raceOutputView,
            WinnersOutputView winnersOutputView) {
        this.carService = carService;
        this.racingService = racingService;
        this.winnerService = winnerService;

        this.carInputView = carInputView;
        this.numberInputView = numberInputView;
        this.raceOutputView = raceOutputView;
        this.winnersOutputView = winnersOutputView;
    }

    public void run() {
        String inputNames = carInputView.inputNames();
        carService.saveAllByInput(inputNames);

        String rawNumber = numberInputView.input();
        raceOutputView.printExecutionPrompt();
        racingService.race(rawNumber);

        List<Car> winners = winnerService.getWinners();
        winnersOutputView.print(winners);
    }
}
