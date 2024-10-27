package racingcar.domain.game;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementCheckerTest {

    private static final int THRESHOLD = 4;

    @Test
    void 난수가_4_이상인_경우() {
        MovementChecker movementChecker = new MovementChecker() {
            @Override
            public boolean isMovable() {
                int randomNumber = 4;
                return randomNumber >= THRESHOLD;
            }
        };

        boolean result = movementChecker.isMovable();
        assertThat(result).isTrue();
    }

    @Test
    void 난수가_4_미만인_경우() {
        MovementChecker movementChecker = new MovementChecker() {
            @Override
            public boolean isMovable() {
                int randomNumber = 3;
                return randomNumber >= THRESHOLD;
            }
        };

        boolean result = movementChecker.isMovable();
        assertThat(result).isFalse();
    }
}
