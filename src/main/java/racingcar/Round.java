package racingcar;

public class Round {

    private final int round;

    public Round(int round) {
        this.round = round;
        validateInteger();

    }


    private void validateInteger() {
        if (round < 1) {
            throw new IllegalArgumentException("a");
        }
    }

    public void process(Cars cars) {
        for (int i = 0; i < round; i++) {
            cars.moveForward();
        }
    }


}
