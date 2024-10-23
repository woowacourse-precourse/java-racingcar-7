package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList;

    public Game(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public void start() {
        for (Car car : carList) {
            RandomNumber randomNumber = new RandomNumber();
            boolean isMove = randomNumber.start();
            if (isMove) {
                car.updateDistance();
            }
        }
        //end for loop
    }
}
