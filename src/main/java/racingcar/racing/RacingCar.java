package racingcar.racing;

import static racingcar.common.RacingCarConstant.FORWARD_BAR;

public class RacingCar extends Racer {

    private String name;
    private String progressState;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getProgressState() {
        return progressState;
    }

    public void forward() {
        progressState += FORWARD_BAR;
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
    }
}
