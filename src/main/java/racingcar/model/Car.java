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
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }

    public String getRaceInfo() {
        StringBuilder raceInfo = new StringBuilder();
        raceInfo.append(name);
        raceInfo.append(Constants.RESULT_COLON);
        raceInfo.append(Constants.DISTANCE_DASH.repeat(distance));
        return raceInfo.toString();
    }
}