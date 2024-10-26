package racingcar;

import java.util.List;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        List<String> carNames = inputView.receiveCarNames();
    }
}
