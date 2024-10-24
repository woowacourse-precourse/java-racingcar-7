package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, StringSplitter stringSplitter, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringSplitter = stringSplitter;
        this.racingService = racingService;
    }

    public void run() {
        outputView.askCarName();
        String carNames = inputView.askCarName();
        List<String> carList = stringSplitter.split(carNames);
        racingService.saveCarName(carList);
    }
}
