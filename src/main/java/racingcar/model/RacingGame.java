package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    // 쉼표(,)를 기준으로 자동차 이름을 분리
    public RacingGame(String carNames) {
        cars = new ArrayList<>();

        for (String name : carNames.split(",")) {
            cars.add(new Car(name.trim()));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == findMaxPosition()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }
}
