package racingcar.controller;

import java.util.List;
import racingcar.service.CarService;
import racingcar.service.InputParsingService;
import racingcar.service.RacingHistoryService;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarControllerImpl implements RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParsingService parsingService;
    private final RacingService racingService;
    private final CarService carService;
    private final RacingHistoryService racingHistoryService;

    public RacingCarControllerImpl(InputView inputView, OutputView outputView, InputParsingService parsingService,
                                   RacingService racingService, CarService carService,
                                   RacingHistoryService racingHistoryService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parsingService = parsingService;
        this.racingService = racingService;
        this.carService = carService;
        this.racingHistoryService = racingHistoryService;
    }

    @Override
    public void run() {
        List<String> carNameList = parsingService.parseCarNameListString(inputView.inputCarNameList());
        carService.createCarsFromNameList(carNameList);
        int attemptCount = parsingService.parseAttemptCountString(inputView.inputAttemptCount());
        racingService.startRacing(attemptCount);
        outputView.printOutputStart();
        for (int roundNumber = 0; roundNumber < attemptCount; roundNumber++) {
            outputView.printRacingHistoryByRound(racingHistoryService.findHistoryByRound(roundNumber));
        }
        outputView.printWinner(racingService.selectWinner());
    }
}
