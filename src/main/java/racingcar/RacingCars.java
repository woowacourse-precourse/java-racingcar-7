package racingcar;

import java.util.ArrayList;
import java.util.List;

// 레이싱에 참가하는 자동차들을 관리
public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public void addCars(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i)));
        }
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxPosition) {
                maxPosition = cars.get(i).getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPosition() == maxPosition) {
                winners.add(cars.get(i).getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
