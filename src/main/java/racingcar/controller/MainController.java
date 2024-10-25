package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import javax.xml.transform.Result;
import racingcar.view.InputView;

public class MainController {

    private final InputView inputView;

    public MainController() {
        this.inputView = new InputView();
    }

    public void run() {
        String carNames = inputView.inputCarName();
        List<String> names = NameController.getCarNames(carNames);
        String inputAttempt = inputView.inputAttempt();
        int attempt = AttemptController.getAttempt(inputAttempt);
        HashMap<String, Integer> gameRecord = GameController.gamePlay(names, attempt);
        ResultController.resultGame(gameRecord);
    }
}
