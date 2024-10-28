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

        // 입력값이 공백이거나 null인 경우 예외 처리
        if (inputDTO == null || inputDTO.getInput().trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        racingCarView.showRoundTimeInfo();
        int roundTime = racingCarView.getInputRoundTime().getRoundTime();

        // 자동차 실행횟수가 공백인 경우, 음수인 경우에 대한 예외 처리
        if (roundTime < 0) {
            throw new IllegalArgumentException("시행횟수는 공백이나 음수가 들어와서는 안됩니다.");
        }
        List<CarDTO> carDTOList = racingCarService.splitCarName(inputDTO);

        racingCarView.showResultInfo();
        racingCarService.startRace(carDTOList, roundTime);


        List<CarDTO> winnerCarList = racingCarService.determineWinners(carDTOList);
        racingCarView.printWinners(winnerCarList);

    }
}
