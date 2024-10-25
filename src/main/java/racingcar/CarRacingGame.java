package racingcar;

import java.util.List;

public class CarRacingGame {

    private final List<ICar> carList;
    private final int round;

    public CarRacingGame(List<ICar> carList, int round) {
        this.carList = carList;
        this.round = round;
    }
}
