package racingcar;

import racingcar.view.OutputView;

public class RacingCarController {
    OutputView outputView;

    public RacingCarController() {
        outputView = new OutputView();
    }

    public void run(){
        outputView.startMessagePrint();
    }
}
