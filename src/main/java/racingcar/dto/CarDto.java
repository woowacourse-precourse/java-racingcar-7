package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String carname;
    private final Integer distance;

    public CarDto(Car car) {
        carname = car.getCarname();
        distance = car.getCarDistance();
    }

    public CarDto(String carname, Integer distance) {
        this.carname = carname;
        this.distance = distance;
    }

    public String getCarname() {
        return carname;
    }

    public Integer getDistance() {
        return distance;
    }
}
