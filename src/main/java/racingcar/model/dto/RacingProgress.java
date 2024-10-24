package racingcar.model.dto;

import racingcar.model.entity.Car;

/**
 * 자동차 주행 과정을 전달하는 DTO
 */
public class RacingProgress {

    private final String name;

    private final int progress;

    public RacingProgress(Car car) {
        this.name = car.getName();
        this.progress = car.getProgress();
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, progress));
    }

}
