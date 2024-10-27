package racingcar.mvc.model.observer;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;

public class Car implements CarObserver {
    private static final String UNIT_OF_DISTANCE = "-";
    private String name;
    private BigInteger distance = BigInteger.ZERO;

    public Car(String name) {
        this.name = name;
    }

    public BigInteger getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {
        if (goOrStop()) {
            distance = distance.add(BigInteger.ONE);
        }

        //여기를 뷰로 내보내고 싶은데...
        System.out.println(this);
    }

    private boolean goOrStop() {
        return makeRandomNumber() >= 4;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public String toString() {
        return name + " : " + convertDistanceToSign();
    }

    private String convertDistanceToSign() {
        StringBuilder sign = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(distance) < 0; i = i.add(BigInteger.ONE)) {
            sign.append(UNIT_OF_DISTANCE);
        }

        return sign.toString();
    }
}
