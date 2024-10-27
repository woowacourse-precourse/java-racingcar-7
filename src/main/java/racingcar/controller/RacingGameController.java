package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.service.IOService;
import racingcar.model.RandomMoveStrategy;

import java.util.List;

public class RacingGameController {

    private final IOService ioService;

    public RacingGameController() {
        this.ioService = new IOService();
    }

    public void run() {
        List<String> carNames = ioService.readCarNames();
        int tryCount = ioService.readTryCount();

        RacingService racingService = new RacingService(carNames, new RandomMoveStrategy());
        racingService.playGame(tryCount);

        ioService.printProcess(racingService.getRoundRecords());
        ioService.printWinners(racingService.getWinners());
    }

}
