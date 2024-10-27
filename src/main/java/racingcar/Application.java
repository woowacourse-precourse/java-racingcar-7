package racingcar;

import racingcar.common.config.RacingCarConfig;

public class Application {
    public static void main(String[] args) {
        RacingCarConfig config = new RacingCarConfig();
        config.getRacingController().processRace();
    }
}
