package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public void run(){
        OutputView.printCarNamesPrompt();
        InputView inputView = new InputView();

        String carInput = inputView.input();
        String[] carInputs = carInput.split(",");

        List<Car> carNames = new ArrayList<>();
        for (int i = 0; i < carInputs.length; i++) {
            carNames.add(new Car(carInputs[i]));
        }

        Cars cars = new Cars(carNames);
        OutputView.printAttemptCountPrompt();

        int tryCount = Integer.parseInt(inputView.input());

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
        }




    }

}
