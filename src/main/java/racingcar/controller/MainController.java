package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class MainController {

    private final InputView inputView;

    public MainController() {
        this.inputView = new InputView();
    }

    public void run() {
        String carNames = inputView.inputCarName();
        List<String> names = NameController.getCarNames(carNames);
        for(String name : names) {
            System.out.println(name);
        }
    }
}
