package racingcar.car.service.dto;

import racingcar.car.domain.Car;

public class CarMoveRespDto {
    private String carName;

    private Integer position;

    public CarMoveRespDto(String carName, Integer position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarMoveRespDto from(Car car) {
        return new CarMoveRespDto(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public Integer getPosition() {
        return position;
    }
}
