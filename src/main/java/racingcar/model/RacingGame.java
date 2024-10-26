package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public final List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound(MoveStrategy moveStrategy){
        for (Car car : cars){
            car.move(moveStrategy);
        }
    }
}
