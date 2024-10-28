package racingcar.car.domain;

import racingcar.car.constant.RacingLimit;
import racingcar.car.service.dto.CarCreateReqDto;

public class Car {
    private String name;

    private Integer position;

    private Car(String name) {
        this.name = name;
        this.position = RacingLimit.START_POINT.getNumber();
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        this.position += RacingLimit.MOVING_FORWARD.getNumber();
    }

    public static Car from(CarCreateReqDto reqDto) {
        return new Car(reqDto.getCarName());
    }
}
