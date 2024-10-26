package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    static private String SPLIT_SIGN=",";

    public void runningGame(){
        String racingCarNames = inputView.InputCarNames();
        Integer trialCount = inputView.InputTrialCount();
        List<Car> carGroup = createCars(racingCarNames);
        Cars cars = new Cars(carGroup);
    }

    private String[] splitCarNames(String racingCarNames) {
        String[] carNames = racingCarNames.split(SPLIT_SIGN);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private List<Car> createCars(String racingCarNames){
        String[] carNames = splitCarNames(racingCarNames);
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carGroup.add(car);
        }
        return carGroup;
    }
}
