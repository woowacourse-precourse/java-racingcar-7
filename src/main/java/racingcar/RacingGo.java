package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGo {
    private List<Car> cars;
    private int moveCount;

    public RacingGo(List<String> carNames, int moveCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.moveCount = moveCount;
    }




}
