package racingcar.mvc.model.observer;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;

public class CarRacer extends Racer {
    private static final int MOVING_THRESHOLD = 4;
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_END_NUMBER = 4;

    public CarRacer(String name) {
        super(name);
    }

    @Override
    public void update() {
        if (goOrStop()) {
            distance = distance.add(BigInteger.ONE);
        }
    }

    private boolean goOrStop() {
        return makeRandomNumber() >= MOVING_THRESHOLD;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
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
