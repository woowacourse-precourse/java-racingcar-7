package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Racing {
    private InputView inputView;
    private OutputView outputView;

    public Racing(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        outputView.requestCarNameMessage();
        String carNames = inputView.getCarNames();
        outputView.requestNumberOfRoundsMessage();
        int numberOfRounds = inputView.getNumberOfRounds();

    }


}
