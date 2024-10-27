package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private InputView inputView;
    private OutputView outputView;
    private RacingCars racingCars;
    private UserInputProcessor userInputProcessor;

    public RacingCarController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingCars = null;
        this.userInputProcessor = new UserInputProcessor();
    }

    public void game() {
        List<String> racingCarNames = prepareRacingCarNames();
        Integer totalAttempts = prepareTotalAttempts();

        racingCars = RacingCars.createRacingCars(racingCarNames, totalAttempts);
        
    }

    private List<String> prepareRacingCarNames() {
        return userInputProcessor.processCarName(inputView.getRacingCarNames());
    }

    private Integer prepareTotalAttempts() {
        return userInputProcessor.processTotalAttempts(inputView.getTotalAttempts());
    }
}
