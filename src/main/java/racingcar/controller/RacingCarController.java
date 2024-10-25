package racingcar.controller;

import racingcar.di.RacingCarTemplate;
import racingcar.dto.RacingResult;
import racingcar.model.RacingCars;
import racingcar.service.RacingService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

public class RacingCarController {

    // View
    private final InputView inputView;
    private final OutputView outputView;

    // Model - Service
    private final RacingService racingService;

    // 필요 변수
    private RacingCars racingCars;
    private int tryCount;
    private RacingResult racingResult;

    public RacingCarController(RacingCarTemplate racingCarTemplate) {
        this.inputView = racingCarTemplate.inputView();
        this.outputView = racingCarTemplate.outputView();
        this.racingService = racingCarTemplate.racingService();
    }

    public void run() {
        setUp();
        playRacing();
        printRacingResult(racingResult);
    }

    // core 함수
    private void setUp() {
        setUpRacingCars();
        setUpTryCount();
    }

    private void playRacing() {
        racingResult = racingService.play(racingCars, tryCount);
    }

    private void printRacingResult(RacingResult racingResult) {
        outputView.printRacingRoundResults(racingResult.roundResults());
        outputView.printWinners(racingResult.winners());
    }

    // helper 함수
    private void setUpRacingCars() {
        List<String> carNameList = getCarNames();

        racingCars = createRacingCars(carNameList);
    }

    private void setUpTryCount() {
        tryCount = getTryCount();
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
