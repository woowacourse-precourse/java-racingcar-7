package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceTrack {
    List<Car> carList;

    public RaceTrack(List<Car> carList) {
        this.carList = carList;
    }

    public void run() {
        for(Car car : carList) {
            car.move();
        }
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
