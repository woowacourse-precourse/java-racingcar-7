package racingcar;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;

public class Judgment {

    public List<String> makeWinnerNameList(Cars cars) {
        return calculateWinnerName(cars);
    }

    private List<String> calculateWinnerName(Cars cars) {
        List<String> winnerList = new ArrayList<>();
        List<Car> carList = cars.toList();
        int maxPosition = calculateMaxPosition(cars);

        carList.forEach(car -> {
            if (car.getPosition() == maxPosition) {
                winnerList.add(car.getName());
            }
        });
        return winnerList;
    }

    private int calculateMaxPosition(Cars cars) {
        List<Car> carList = cars.toList();
        int max = 0;
        for (Car car : carList) {
            max = max(max, car.getPosition());
        }
        return max;
    }
}
