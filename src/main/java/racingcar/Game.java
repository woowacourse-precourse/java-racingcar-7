package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList;

    public Game(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public void updateCarMove(Car car) {
        RandomNumber randomNumber = new RandomNumber();
        boolean isMove = randomNumber.pick();
        if (isMove) {
            car.updateDistance();
        }
    }

    public void play() {
        for (Car car : carList) {
            updateCarMove(car);
        }
        //end for loop
    }
}
