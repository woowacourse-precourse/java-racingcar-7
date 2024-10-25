package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final static String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void run(){
        outputView.printCarNameRequest();
        racingCarService.registerRacingCars(StringUtil.splitNames(inputView.getCarNames(), DELIMITER));

    }

}
