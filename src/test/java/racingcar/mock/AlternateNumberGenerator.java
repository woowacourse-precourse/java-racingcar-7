package racingcar.mock;

import racingcar.domain.game.NumberGenerator;

public class AlternateNumberGenerator implements NumberGenerator {
    private static final int EVEN_CALL_NUMBER = 2;
    private static final int ODD_CALL_NUMBER = 5;

    private int callCount = 0;

    @Override
    public int generate() {
        incrementCallCount();

        if (isEvenCall()) {
            return EVEN_CALL_NUMBER;
        }
        return ODD_CALL_NUMBER;
    }

    private void incrementCallCount() {
        callCount++;
    }

    private boolean isEvenCall() {
        return callCount % 2 == 0;
    }
}