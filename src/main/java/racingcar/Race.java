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

    public void findWinner(List<Car> carList) {
        winnerList.add(carList.get(0));
        for (int i = 1; i < carList.size(); i++) {
            Car currentCar = carList.get(i);
            if (currentCar.getProgress() > winnerList.get(0).getProgress()) {
                winnerList.clear();
                winnerList.add(currentCar);
            }
            if (currentCar.getProgress() == winnerList.get(0).getProgress()) {
                winnerList.add(currentCar);
            }
        }
    }
}
