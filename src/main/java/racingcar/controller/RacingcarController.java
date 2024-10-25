package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.PresetService;
import racingcar.service.ProcessService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PresetService presetService = new PresetService();
    private final ProcessService processService = new ProcessService();

    public void play() {
        Game game = gamePreset();
        int maxRound = getRound();
        gameProcessing(game, maxRound);
    }

    private Game gamePreset() {
        outputView.printNameGuide();
        return presetService.setGame(inputView.inputName());
    }

    private int getRound() {
        outputView.printRoundGuide();
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
