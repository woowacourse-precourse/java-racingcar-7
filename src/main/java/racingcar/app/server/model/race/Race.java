package racingcar.app.server.model.race;

import static java.util.Objects.requireNonNull;
import static racingcar.app.server.error.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;
import static racingcar.app.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

import java.util.Objects;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Race {

    private Lap remainingCount;

    private Race(final Lap remainingCount) {
        this.remainingCount = remainingCount;
    }

    public static Race from(final Lap lap) {
        requireNonNull(lap, SHOULD_NOT_BE_NULL);
        return new Race(lap);
    }

    public boolean isUnderway() {
        return remainingCount.hasRemaining();
    }

    public void countDownRemainingLapCount(Lap countDownAmount) {
        if (remainingCount.isZero()) {
            throw new ShouldNotBeMinusException(LAP_COUNT_SHOULD_NOT_BE_MINUS);
        }
        this.remainingCount = remainingCount.minus(countDownAmount);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Race oRace = (Race) obj;
        return this.remainingCount.equals(oRace.remainingCount);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(remainingCount);
    }
}
