package racingcar.model;

import java.util.ArrayList;

public class Race {
    private RaceTurn turn;
    private ArrayList<Car> carList;

    public Race(int turn) {
        this.turn = new RaceTurn(turn);
    }

    public void join(Car car) {
        this.carList.add(car);
    }
}
