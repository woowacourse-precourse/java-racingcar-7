package racingcar.model;

import java.util.List;

public class Racing {

    public List<Car> findWinners(List<Car> cars, int maxMarkerCount) {
        return cars.stream()
                   .filter(car -> car.getAdvanceMarkerCount() == maxMarkerCount)
                   .toList();
    }

    public void advance(Cars cars, int number) {
        for (Car car : cars.getCars()) {
            if (number > 3) {
                car.addAdvanceMarker();
            }
        }
    }
}
