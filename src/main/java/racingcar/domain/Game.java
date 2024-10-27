package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static List<RacingHistory> play(Race race) {
        List<RacingHistory> histories = new ArrayList<>();
        for (int i = 0; i < race.getRoundCount(); i++) {
            for (Car car : race.getCars()) {
                histories.add(car.move());
            }
        }
        return histories;
    }
}
