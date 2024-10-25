package racingcar.controller;

import racingcar.di.RacingCarTemplate;
import racingcar.dto.RacingResult;
import racingcar.model.RacingCars;
import racingcar.service.RacingService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

public class RacingController {

    // View
    private final InputView inputView;
    private final OutputView outputView;

    // Model - Service
    private final RacingService racingService;

    // 필요 변수
    private RacingCars racingCars;
    private int tryCount;
    private RacingResult racingResult;

    public RacingController(RacingCarTemplate racingCarTemplate) {
        this.inputView = racingCarTemplate.inputView();
        this.outputView = racingCarTemplate.outputView();
        this.racingService = racingCarTemplate.racingService();
    }

    public void setUpRacingCars() {
        List<String> carNameList = getCarNames();
        racingCars = createRacingCars(carNameList);
    }

    public void setUpTryCount() {
        tryCount = getTryCount();
    }

    public void playRacing() {
        racingResult = racingService.play(racingCars, tryCount);
    }

    public void printRacingResult() {
        outputView.printRacingRoundResults(racingResult.roundResults());
        outputView.printWinners(racingResult.winners());
    }

    private RacingCars createRacingCars(List<String> carNameList) {
        return racingService.getRacingCars(carNameList);
    }

    private List<String> getCarNames() {
        outputView.printInputCarNames();
        return inputView.getCarNames();
    }

    private int getTryCount() {
        outputView.printInputTryCount();
        return inputView.getTryCount();
    }
}
