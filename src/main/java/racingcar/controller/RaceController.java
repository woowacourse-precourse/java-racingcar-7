package racingcar.controller;

import java.util.List;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = OutputView.getInstance();

        String carsNames = inputView.inputCarName();
        String repeatTimes = inputView.inputRepeatTimes();

        outputView.roundResultHeader();
        RaceService raceService = new RaceService();
        List<String> finalWinners = raceService.startRacing(carsNames, repeatTimes);
        outputView.printRoundResult(raceService.getAllRoundStatus());
        outputView.printFinalResult(finalWinners);
    }
}
