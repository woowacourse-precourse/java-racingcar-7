package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.PresetService;
import racingcar.service.ProcessService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PresetService presetService;
    private final ProcessService processService;

    public RacingcarController(
            InputView inputView,
            OutputView outputView,
            PresetService presetService,
            ProcessService processService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.presetService = presetService;
        this.processService = processService;
    }

    public void play() {
        Game game = gamePreset();
        int maxRound = getRound();
        gameProcessing(game, maxRound);
    }

    private Game gamePreset() {
        return presetService.setGame(inputView.inputName());
    }

    private int getRound() {
        return inputView.inputRound();
    }

    private void gameProcessing(Game game, int maxRound) {
        outputView.printResultMessage();
        for (int round = 0; round < maxRound; round++) {
            game.play();
            outputView.printRacingProgress(game.getRacingCarArray());
        }
        ArrayList<Car> winners = processService.getWinnerCar(game);
        outputView.printExecuteResult(winners);
    }
}
