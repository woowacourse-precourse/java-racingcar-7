package racingcar.entity;

import static racingcar.constant.RacingCarStatic.DEFAULT_MOVE_DISTANCE;
import static racingcar.constant.RacingCarStatic.DISTANCE_TRACKING_FORMAT;

import java.math.BigInteger;

public class RacingCar {

    private final String name;
    private BigInteger distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = BigInteger.ZERO;
    }

    public BigInteger getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.distance = distance.add(BigInteger.valueOf(DEFAULT_MOVE_DISTANCE));
    }

    public String getFormattedDistance() {
        StringBuilder sb = new StringBuilder();
        for (BigInteger i = BigInteger.ZERO; i.compareTo(distance) < 0; i = i.add(BigInteger.ONE)) {
            sb.append(DISTANCE_TRACKING_FORMAT);
        }
        return sb.toString();
    }
}
