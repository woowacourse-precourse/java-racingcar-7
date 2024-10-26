package racingcar.entity;

import static racingcar.constant.RacingCarStatic.DEFAULT_MOVE_RANGE;
import static racingcar.constant.RacingCarStatic.DISTANCE_TRACKING_FORMAT;

import java.math.BigInteger;

public class RacingCar {

    //TODO: 자동차 경주의 주체가 될 자동차들을 정의하는 엔티티 클래스
    private String name;
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
        this.distance = distance.add(BigInteger.valueOf(DEFAULT_MOVE_RANGE));
    }

    public String getFormattedDistance() {

        //FIXME: BIGINTEGER 방식?
        StringBuilder sb = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(distance) < 0; i = i.add(BigInteger.ONE)) {
            sb.append(DISTANCE_TRACKING_FORMAT);
        }

        return sb.toString();
    }
}
