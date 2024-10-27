package racingcar.controller;

import java.util.List;
import racingcar.model.RaceLog;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    RaceService raceService;
    InputView inputView;
    OutputView outputView;

    private RaceController(RaceService raceService, InputView inputView, OutputView outputView) {
        this.raceService = raceService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private static class Holder {
        private static RaceController instance;
    }

    public static RaceController getInstance(RaceService raceService, InputView inputView, OutputView outputView) {
        if (Holder.instance == null) {
            Holder.instance = new RaceController(raceService, inputView, outputView);
        }
        return Holder.instance;
    }

    public void run() {
        raceService.setRaceCars(inputView.inputCarNames());
        outputView.printRaceLogs(raceService.runRaceRounds(Integer.parseInt(inputView.inputTryCount())));
        outputView.printRaceWinners(raceService.generateWinners());
    }
}
