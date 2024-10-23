package racingcar;

import racingcar.view.InputData;
import racingcar.view.InputView;
import racingcar.view.OutView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        InputData inputData = inputView.inputCars();

        OutView outView = new OutView();
        outView.displayResult(inputData);
    }
}