package racingcar.util;


import racingcar.view.RacingCarView;

public abstract class RacingCarStarter {

    private static final RacingCarView racingCarView =
            SingletonObjectProvider.getSingletonObject(RacingCarView.class);

    public static void start() {
        racingCarView.startCalculateProgram();
    }
}