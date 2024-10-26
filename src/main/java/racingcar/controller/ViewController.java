package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class ViewController {
    private static ViewController viewController;
    private static InputView inputView=InputView.getInstance();
    private static OutputView outputView=OutputView.getInstance();

    public static ViewController getInstance() {
        if (viewController == null){
            viewController = new ViewController();
        }
        return viewController;
    }

    public void printGuide(){
        outputView.inputMessage();
        inputView.readLine();
    }
}
