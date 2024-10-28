package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.util.GameManager;
import racingcar.util.Saparator;
import racingcar.validation.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private ArrayList<Car> cars;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    GameManager gameManager = new GameManager();

    public void start() {
        setCars();
        playGame();
        printResult();
    }

    public void setCars() {
        String input = inputView.getCarNames();
        cars = gameManager.setCars(input);
    }

    public void playGame() {
        int time = inputView.getPlayTime();
        outputView.printResult();
        for (int i = 0; i < time; i++) {
            gameManager.playOneTime(cars);
            outputView.printCarStatus(cars);
        }
    }

    public void printResult() {
        outputView.printFinalWinner(gameManager.getWinner(cars));
    }

}
