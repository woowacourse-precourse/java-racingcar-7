package racingcar.controller;

import racingcar.Validator;
import racingcar.domain.Car;
import racingcar.model.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final Validator validator;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.validator = validator;
    }

    public void start() {
        List<Car> carList = initializeCarsList();
        int tryCounts = inputTryCounts();
        outputView.displayRaceResultMessage();
        conductRace(carList, tryCounts);
        displayRaceResults(carList);
    }

    private int inputTryCounts() {
        outputView.displayTryCountsMessage();
        String tryCounts = inputView.getTryCounts();
        validator.validateTryCounts(tryCounts);
        return Integer.parseInt(tryCounts);
    }

    private void displayRaceResults(List<Car> carList) {
        outputView.displayWinnersMessage(racingService.checkWinnerList(carList));
    }

    private void conductRace(List<Car> carList, int tryCounts) {
        for (int i = 0; i < tryCounts; i++) {
            racingService.executeRound(carList);
            outputView.displayRaceProgressMessage(carList);  // 라운드 진행 후 경주 상태 출력
        }
    }

    private List<Car> initializeCarsList() {
        outputView.displayCarNameMessage();
        String carNames = inputView.getCarNames();
        validator.validateCarNames(carNames);
        return racingService.convertNamesToCars(carNames);
    }
}
