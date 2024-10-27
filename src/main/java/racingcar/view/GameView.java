package racingcar.view;

import java.util.List;
import racingcar.Car;

public class GameView {

    public void LiveScore(List<Car> cars){

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

}
