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
            car.moveOrNothing(randomNum);
        }
    }

    public String getWinner() {
        int highestScore = getHighestScore();
        List<String> winnerList = createWinnerList(highestScore);
        return String.join(", ", winnerList);
    }

    public List<String> createWinnerList(int highestScore) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMoveCnt() == highestScore) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private int getHighestScore() {
        return carList.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);
    }
}
