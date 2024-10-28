package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
    private RacingCarService racingCarService;

        public void start(){
            List<String> nameList;
            nameList = InputView.getCarNames();
            int tryCount = InputView.getTryCount();
            this.racingCarService = new RacingCarService(nameList);
        }

}
