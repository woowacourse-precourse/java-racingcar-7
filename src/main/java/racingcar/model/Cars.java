package racingcar.model;

import java.util.List;

public class Cars {
    private List<Car> carGroup;

    public Cars(List<Car> carGroup) {
        this.carGroup = carGroup;
    }

    public List<Car> getCarGroup() {
        return carGroup;
    }
}
