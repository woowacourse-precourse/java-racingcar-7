package racingcar;

import java.util.List;

public class RacingGame {

    private final List<ICar> carList;
    private final int round;

    public RacingGame(List<ICar> carList, int round) {
        this.carList = carList;
        this.round = round;
    }
}
