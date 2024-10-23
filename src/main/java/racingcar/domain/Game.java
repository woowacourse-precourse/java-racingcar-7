package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final List<Car> carList;

    private Game(final List<Car> carList) {
        this.carList = carList;
    }

    public static Game carListFrom(final List<Car> carList) {
        return new Game(carList);
    }

    public void moveForward() {
        for (Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.moveForward();
            }
        }
    }

    public String getWinner() {
        List<String> winnerList = new ArrayList<>();
        int highestScore = getHighestScore();
        for (Car car : carList) {
            if (car.getMoveCnt() == highestScore) {
                winnerList.add(car.getName());
            }
        }
        return String.join(", ", winnerList);
    }

    private int getHighestScore() {
        return carList.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);
    }
}
