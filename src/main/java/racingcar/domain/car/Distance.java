package racingcar.domain.car;

import java.util.Objects;

public class Distance {

    private int distance;
    public static int ZERO_DISTANCE = 0;

    public Distance() {
        this.distance = ZERO_DISTANCE;
    }

    public void increase(){
        distance ++;
    }

    public int getDistance() {
        return distance;
    }
}
