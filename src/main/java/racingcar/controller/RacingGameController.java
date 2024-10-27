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
        racingService.play(tryCount);

        ioService.printProcess(racingService.getRounds());
        ioService.printWinners(racingService.getWinners());
    }

}
