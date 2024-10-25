package racingcar;

import static racingcar.RacingConstants.MAX_NUMBER;
import static racingcar.RacingConstants.MIN_NUMBER;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        int number = numberGenerator.pickOne();
    }
}
