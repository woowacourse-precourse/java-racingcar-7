package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RaceCarService;
import racingcar.service.RaceCarServiceImpl;
import racingcar.view.OutputView;

public class CarGameController {
    private List<Car> carNames;
    private int gameCount;
    private final OutputView outputView;

    public CarGameController() {
        setInputs();
        RaceCarService raceCarService = new RaceCarServiceImpl(carNames, gameCount);
        this.outputView = new OutputView(raceCarService);

        playRounds();
        announceWinner();
    }

    private void setInputs() {
        this.carNames = InputController.setCarNames();
        this.gameCount = InputController.setGameCount();
    }

    private void playRounds() {
        outputView.playRounds();
    }

    private void announceWinner() {
        outputView.announceWinner();
    }
}
