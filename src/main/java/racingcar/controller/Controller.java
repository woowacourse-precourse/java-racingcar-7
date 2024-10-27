package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.util.GameManager;
import racingcar.util.Saparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    ArrayList<Car> cars = new ArrayList<>();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Saparator saparator = new Saparator(",");
    GameManager gameManager = new GameManager();

    public void start(){
        String input = inputView.getCarNames();
        String[] carNames = saparator.split(input);

        for (String name : carNames){
            cars.add(new Car(name));
        }

        int time = inputView.getPlayTime();
        outputView.printResult();
        for (int i = 0; i < time; i++) {
            gameManager.playOneTime(cars);
            outputView.printCarStatus(cars);
        }
        outputView.printFinalWinner(gameManager.getWinner(cars));
    }

}
