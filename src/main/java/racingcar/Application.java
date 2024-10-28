package racingcar;

import racingcar.car.Car;
import racingcar.game.Game;
import racingcar.game.InputException;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> carList = new ArrayList<>();
        InputException.getCarName(carList);
        int tryCount = InputException.getTryCount();
    }
}
