package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {
    
    public List<Car> findWinners(List<Car> cars, int maxMarkerCount) {
        return cars.stream()
                   .filter(car -> car.getAdvanceMarkerCount() == maxMarkerCount)
                   .toList();
    }

    public void advance(Cars cars) {
        for (Car car : cars.getCars()) {
            if (isMovable()) {
                car.addAdvanceMarker();
            }
        }
    }

    private boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
