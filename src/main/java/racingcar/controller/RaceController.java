package racingcar.controller;

import racingcar.dto.UserInputDTO;
import racingcar.service.RaceService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    // 프로그램 시작 메소드
    public void raceStart() {
        UserInputDTO userInputDTO = InputView.getUserInput();
        raceService.setNumOfStages(userInputDTO.numOfStages());
        raceService.setCarList(InputParser.getCarList(userInputDTO));
        raceService.raceStart();
//        OutputView.showResult(userInputDTO.numOfStages(), raceService.getCarList(userInputDTO));
    }
}
