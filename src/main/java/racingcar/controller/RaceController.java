package racingcar.controller;

import racingcar.dto.UserInputDTO;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    public void raceStart() {
        UserInputDTO userInputDTO = InputView.getUserInput();
        raceService.initialize(userInputDTO);
        raceService.raceStart();
        OutputView.showResult(this.raceService.getNumOfStages(), this.raceService.getCarList());
    }
}
