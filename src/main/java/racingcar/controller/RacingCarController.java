package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void setRacingCar(InputView inputView) {
        List<String> carNames = racingCarService.processingInputToList(inputView.inputCarNames());
        racingCarService.checkCarNamesValid(carNames);
        racingCarService.saveAll(carNames);
    }

    public void openingRacingGame(InputView inputView, OutputView outputView) {
        BigInteger raceCount = racingCarService.checkRaceCount(inputView.inputRaceCount());
        racingCarService.startRacing(raceCount, outputView);
    }

    public void finalAward(OutputView outputView) {
        List<String> winners = racingCarService.getFinalWinners();
        outputView.printFinalWinners(winners);
    }
}
