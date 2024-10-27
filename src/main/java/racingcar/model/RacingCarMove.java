package racingcar.model;

public class RacingCarMove {

    public int move(final RandomNumber randomNumber) {
        if (randomNumber.generate() >= 4) {
            return 1;
        }
        return 0;
    }
}
