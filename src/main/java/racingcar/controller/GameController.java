package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Move;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private InputView inputView = new InputView();
    static private String SPLIT_SIGN=",";

    private String[] splitCarNames(String racingCarNames) {
        String[] carNames = racingCarNames.split(SPLIT_SIGN);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    private Cars createCars(String racingCarNames){
        String[] carNames = splitCarNames(racingCarNames);
        List<Car> carGroup = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carGroup.add(car);
        }
        Cars cars = new Cars(carGroup);
        return cars;
    }

    private void oneRoundGame(Cars cars){
        Move move = new Move();
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            move.moveFoward(car);
        }
    }

    public void runningGame(){
        String racingCarNames = inputView.InputCarNames();
        Integer trialCount = inputView.InputTrialCount();
        Cars cars = createCars(racingCarNames);
        for(int i=0;i<trialCount;i++){
            oneRoundGame(cars);
        }
    }
}
