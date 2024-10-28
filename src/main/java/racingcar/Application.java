package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> carNames = inputView.getCarNames();
        int count = inputView.getCount();

        CarController carController = new CarController(carNames);
        carController.racingGame(count);


        // outputView.displayResult();
        // outputView.displayWinner();
    }
}
