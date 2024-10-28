package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> carList;
    private int totalRound;

    public Race() {
        this.carList = new ArrayList<>();
        this.totalRound = 0;
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public int getTotalRound() {
        return this.totalRound;
    }

    public void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }
}
