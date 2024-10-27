package racingcar.domain;

import java.util.List;

public class RequestRaceDto {
    private final List<Car> carList;
    private final int tryNumber;

    public RequestRaceDto (List<Car> carList, int tryNumber) {
        this.carList = carList;
        this.tryNumber = tryNumber;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
