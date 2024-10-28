package racingcar.controller;

import racingcar.domain.CarDTO;
import racingcar.domain.InputDTO;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {

    private final RacingCarService racingCarService;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void CarRacingStart() {
        racingCarView.showCarInputInfo();
        InputDTO inputDTO = racingCarView.getInputCarName();
        racingCarView.showRoundTimeInfo();
        int roundTime = racingCarView.getRoundTime();

        List<CarDTO> carDTOList = racingCarService.splitCarName(inputDTO);

        racingCarView.showResultInfo();
        racingCarService.startRace(carDTOList, roundTime);


        List<CarDTO> winnerCarList = racingCarService.determineWinners(carDTOList);
        racingCarView.printWinners(winnerCarList);

    }
}
