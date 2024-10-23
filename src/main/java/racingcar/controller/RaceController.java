package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    // 프로그램 시작 메소드
    public void raceStart() {
        UserInputDTO userInputDTO = InputView.getUserInput();
//        System.out.println(userInputDTO.name());
//        System.out.println(userInputDTO.numOfStages());
        List<Car> carList = raceService.getCarList(userInputDTO);
        OutputView.showResult(userInputDTO.numOfStages(), carList);
    }
}