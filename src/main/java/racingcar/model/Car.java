package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.Constants;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (Randoms.pickNumberInRange(Constants.RANDOM_MIN, Constants.RANDOM_MAX) >= Constants.MOVE_REFERENCE_VALUE) {
            distance++;
        }
    }

    public String getRaceInfo() {
        StringBuilder raceInfo = new StringBuilder();
        raceInfo.append(name);
        raceInfo.append(Constants.COLON);
        raceInfo.append(Constants.DASH.repeat(distance));
        return raceInfo.toString();
    }
}