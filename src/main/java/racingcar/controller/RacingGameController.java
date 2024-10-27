package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingCar;
import racingcar.service.InputService;
import racingcar.service.InputServiceImpl;
import racingcar.service.RacingService;
import racingcar.service.RacingServiceImpl;
import racingcar.service.OutputService;
import racingcar.service.OutputServiceImpl;

public class RacingGameController {
    private final InputService inputService = InputServiceImpl.getInstance();
    private final RacingService racingService = RacingServiceImpl.getInstance();
    private final OutputService outputService = OutputServiceImpl.getInstance();

    public void run() {
        List<RacingCar> rcList
                = inputService.splitUsersAndReturnList(inputService.inputRacingUsersAndSplit());
        int moveCount
                = inputService.inputMoveCount();

        System.out.println("실행 결과");
        while(moveCount != 0) {
            racingService.oneCycle(rcList);
            outputService.notYetFinish(rcList);
            moveCount--;
        }

        outputService.finish(rcList);
    }
}
