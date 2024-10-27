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

    public void playOneRound() {
        for (Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.moveOrNothing(randomNum);
        }
    }

    public String getWinners() {
        List<String> winnerList = extractWinnerList();
        return String.join(", ", winnerList);
    }

    private List<String> extractWinnerList() {
        int highestScore = getHighestScore();
        return createWinnerList(highestScore);
    }

    private int getHighestScore() {
        return carList.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);
    }

    private List<String> createWinnerList(final int highestScore) {
        return carList.stream()
                .filter(c -> c.getMoveCnt() == highestScore)
                .map(Car::getName)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
