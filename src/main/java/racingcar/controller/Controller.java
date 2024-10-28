package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.Parser;
import racingcar.model.RacingGame;

import java.util.ArrayList;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        String input=inputView.inputName();
        int num = inputView.inputNum();
        ArrayList<String> participants = Parser.parse(input);
        outputView.result();
        String winner=RacingGame.race(participants, num);
        outputView.finalWinner(winner);
    }
}
