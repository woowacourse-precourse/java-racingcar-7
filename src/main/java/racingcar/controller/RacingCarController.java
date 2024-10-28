package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void setRacingCar(InputView inputView) {
        String inputCarNames = inputView.inputCarNames();
        List<String> carNames = racingCarService.processingCarNames(inputCarNames);
        racingCarService.validateCarNames(carNames);
        racingCarService.createAll(carNames);
    }

    public void startRacingGame(InputView inputView, OutputView outputView) {
        String inputRaceCount = inputView.inputRaceCount();
        racingCarService.validateRaceCount(inputRaceCount);
        outputView.printTrackingStartMsg();
        Map<String, String>[] raceResults = racingCarService.startRacingAndTracking(new BigInteger(inputRaceCount));
        outputView.printRaceProcess(new BigInteger(inputRaceCount), raceResults);
    }

    public void finalAward(OutputView outputView) {
        List<String> winners = racingCarService.getFinalWinners();
        outputView.printFinalWinners(winners);
    }
}
