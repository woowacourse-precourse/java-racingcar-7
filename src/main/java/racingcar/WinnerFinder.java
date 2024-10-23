package racingcar;

import java.util.List;

public class WinnerFinder {

    private static WinnerFinder searchWinner;

    private WinnerFinder() {
    }

    public static WinnerFinder getInstance() {
        if (searchWinner == null) {
            searchWinner = new WinnerFinder();
        }
        return searchWinner;
    }

    public List<Car> find(Cars cars) {
        return cars.getWinner(cars.maxForward());
    }
}
