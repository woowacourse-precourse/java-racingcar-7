package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> winnerList;

    public Race() {
        winnerList = new ArrayList<>();
    }

    public void racing(List<Car> carList, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : carList) {
                car.move(attemptCount - i);
            }
        }
    }
}
