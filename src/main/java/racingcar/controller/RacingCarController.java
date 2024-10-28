package racingcar.controller;

import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final OutputView outputView = new OutputView();

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
            outputView.displayRaceStatus(racingCarService.getCarList());
        }
    }
}
