package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        List<String> carNameList;
        String carNames;
        int tryCount;

        inputView.displayCarNamesPrompt();
        carNames = inputView.inputCarNames();
        inputView.displayTryCountPrompt();
        tryCount = inputView.inputTryCount();
        carNameList = inputView.splitCarNamesToList(carNames);
        racingCarService.prepareCars(carNameList);

        while (tryCount-- > 0) {
            racingCarService.startRace();
        }
    }
}
