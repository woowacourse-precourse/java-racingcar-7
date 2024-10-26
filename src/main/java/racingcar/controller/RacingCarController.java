package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void setRacingCar(InputView inputView) {
        List<String> carNames = racingCarService.processingInputToList(inputView.inputCarNames());
        racingCarService.checkCarNamesValid(carNames);
        racingCarService.saveAll(carNames);

        racingCarService.printAllNames();   //TODO : remove it
    }

    public void startRacingGame() {
        //TODO : 본격적으로 자동차 경주 게임을 진행하는 일련의 과정
    }

    public void finalAward() {
        //TODO : 최종 결과를 산출하여 우승자를 가리는 일련의 과정
    }
}
