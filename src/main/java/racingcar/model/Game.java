package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int playCount;
    private List<Car> carList;
    private List<Car> winnerList;

    public Game(int playCount, List<Car> carList) {
        this.playCount = playCount;
        this.carList = carList;
        this.winnerList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public void addWinner(Car car) {
        winnerList.add(car);
    }

}
