package racingcar.dto;

import java.util.List;

public class Winners {
    private List<CarDto> cars;

    public Winners(List<CarDto> cars) {
        this.cars = cars;
    }

    public List<String> getWinnerNames() {
        return cars.stream().map(CarDto::getCarName).toList();
    }
}
