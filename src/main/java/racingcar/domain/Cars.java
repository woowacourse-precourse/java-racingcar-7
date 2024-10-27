package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    public List<Car> findWinner(int maxLocation) {

        List<Car> winnerList = new ArrayList<>();

        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }

    public int getMaxLocation() {

        int maxLocation = 0;

        for (Car car : cars) {
            if (car.getLocation() > maxLocation) {
                maxLocation = car.getLocation();
            }
        }

        return maxLocation;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
        // 방어적 복사
    }
}
