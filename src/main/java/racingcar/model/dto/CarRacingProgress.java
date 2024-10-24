package racingcar.model.dto;

import racingcar.model.domain.Car;

/**
 * 자동차 주행 과정을 전달하는 DTO
 */
public class CarRacingProgress {

    private final String name;

    private final int progress;

    public CarRacingProgress(Car car) {
        this.name = car.getName();
        this.progress = car.getProgress();
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, progress));
    }

}
