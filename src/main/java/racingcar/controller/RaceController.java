package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final OutputView outputView;
    private final InputView inputView;

    public RaceController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void raceRun() {
        outputView.printCarNameInputPrompt();
        String input = inputView.getStrInput();
        List<String> carNameList = Utils.splitNames(input);
        outputView.printInputAttempsPrompt();
        int attemptCount = Utils.inputToInt(inputView.getStrInput());
        Race race = new Race(carNameList);
        outputView.printResultPrompt(); // "실행 결과" 출력
        race.runRace(attemptCount);
        List<Car> winners = race.getWinners();
        outputView.showWinners(winners);
    }
}
