package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class Game {

    private Movement movement = new Movement();

    public HashMap<String, Integer> play(HashMap<String, Integer> raceStatus) {

        for (String key : raceStatus.keySet()) {
            if (movement.forward()) {
                raceStatus.put(key, raceStatus.get(key) + 1);
            }
        }
        return raceStatus;
    }
}
