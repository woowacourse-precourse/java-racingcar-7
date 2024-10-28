package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run(){
        String input=inputView.input();
    }
}
