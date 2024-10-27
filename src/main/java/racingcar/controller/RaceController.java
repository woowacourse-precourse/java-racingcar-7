package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private RaceService raceService;
    private InputView inputView;
    private OutputView outputView;

    public RaceController() {
        this.raceService = new RaceService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        String inputCarNames = inputView.inputCarNames();
        int tryCount = inputView.inputTryCount();

        String[] carNames = raceService.splitCarNames(inputCarNames);
        List<Car> cars = raceService.createCars(carNames);

        Race race = new Race(cars, tryCount);

        System.out.println();
        outputView.outputResultMessage();
        for (int i = 0; i < race.getTryCount(); i++) {
            race.playOneRound();
            outputView.outputOneRoundResult(race.getCars());
            System.out.println();
        }

        List<String> winners = race.getWinners();
        outputView.outputWinners(winners);
    }
}
