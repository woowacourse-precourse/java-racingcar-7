package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    OutputView outputView;
    InputView inputView;

    public RacingCarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run(){
        outputView.startMessagePrint();
        String readCarString = inputView.readCarString(); // 추후 이 메세지와 시도 횟수는 객체에서 관리하도록 수정시도해볼 예정
        outputView.tryCountMessage();
        String readTryCount = inputView.readTryCount();
    }
}
