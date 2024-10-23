package racingcar.model;

import racingcar.utils.Constants;

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
        return name + " ".repeat(Constants.MAX_CAR_NAME_LENGTH - name.length())
                + " : " + "-".repeat(Math.max(0, progress));
    }

}
