package racingcar.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
    }

    public void setRacingCar() {
        String inputCarNames = inputView.inputCarNames();
        List<String> carNames = racingCarService.processingCarNames(inputCarNames);
        racingCarService.validateCarNames(carNames);
        racingCarService.createAll(carNames);
    }

    public void startRacingGame() {
        String inputRaceCount = inputView.inputRaceCount();
        racingCarService.validateRaceCount(inputRaceCount);
        outputView.printTrackingStartMsg();
        Map<String, String>[] raceResults = racingCarService.startRacingAndTracking(new BigInteger(inputRaceCount));
        outputView.printRaceProcess(new BigInteger(inputRaceCount), raceResults);
    }

    public void finalAward() {
        List<String> winners = racingCarService.getFinalWinners();
        outputView.printFinalWinners(winners);
    }
}
