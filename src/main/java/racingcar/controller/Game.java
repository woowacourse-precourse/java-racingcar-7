package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class Game {
    private InputView inputView;

    public Game(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){
        String[] carNames = inputView.getCarNames();
        int moveCount = inputView.getMoveCount();

        List<Car> carList = createCar(carNames);

        while(moveCount -- > 0){
            moveCars(carList);
        }

    }

    private List<Car> createCar(String[] carNames){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private void moveCars(List<Car> carList){
        for (Car car : carList) {
            car.move();
        }
    }
}
