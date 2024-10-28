package racingcar.model.dto;

import racingcar.model.entity.Car;

/** 자동차 주행 과정을 담아 전달하는 DTO */
public record RacingProgress(String name, int progress)  {

    public RacingProgress(Car car) {
        this(car.getName(), car.getProgress());
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, progress));
    }

}
