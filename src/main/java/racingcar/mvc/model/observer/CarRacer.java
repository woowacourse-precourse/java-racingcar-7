package racingcar.mvc.model.observer;

import camp.nextstep.edu.missionutils.Randoms;

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
            distance++;
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

        for (int i = 0; i < distance; i++) {
            sign.append(UNIT_OF_DISTANCE);
        }

        return sign.toString();
    }
}
