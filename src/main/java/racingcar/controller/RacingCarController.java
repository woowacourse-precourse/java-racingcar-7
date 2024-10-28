package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedList;
import java.util.List;

public class RacingCarController {
    private final static String DELIMITER = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final List<RacingCar> racingCarList;

    public RacingCarController(InputView inputView, OutputView outputView, RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCarService = racingCarService;
        this.racingCarList = new LinkedList<>();
    }

    public void run() {
        outputView.printCarNameRequest();
        registerRacingCars();

        outputView.printRaceCountRequest();
        int tryCount = StringUtil.parsePositiveNumber(inputView.getLine());

        outputView.printRacingStartMessage();
        racing(tryCount);

        List<RacingCar> winners = racingCarService.findWinner(racingCarList);
        outputView.printWinner(winners);
    }

    private void registerRacingCars() {
        String input = inputView.getLine();
        List<String> carNames = StringUtil.splitNames(input, DELIMITER);
        racingCarService.registerRacingCars(racingCarList, carNames);
    }

    private void racing(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingCarService.racingGame(racingCarList);
            outputView.printRacingStatus(racingCarList);
        }
    }

}
