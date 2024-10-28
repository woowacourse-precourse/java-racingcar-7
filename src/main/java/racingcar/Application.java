package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String cars = inputView.inputCar();
        int turn = inputView.inputTurn();

        GameController gameController = GameController.getInstance();
        gameController.game(cars, turn);
    }
}
