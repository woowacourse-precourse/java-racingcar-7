package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        String carNames = getCarNames();
    }

    private static String getCarNames() {
        outputView.printInputCarNames();
        return inputView.getCarNames();
    }
}
