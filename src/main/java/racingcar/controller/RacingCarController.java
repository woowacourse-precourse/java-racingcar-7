package racingcar.controller;

import racingcar.model.LacingCar;
import racingcar.service.LacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingCarController {

    public void startRacing() {
        LacingCarService lacingCarService = new LacingCarService();
        lacingCarService.moveRacingCar();
    }

}
