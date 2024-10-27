package racingcar.carrace;

import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Parser;

public class CarRace {
    private List<Car> carList;
    private int remainNum;

    public CarRace(String cars, int num) {
        carList = Parser.parseCarList(cars);
        remainNum = num;
    }

}
