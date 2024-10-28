package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.executor.decider.movement.RandomMovementDeciderImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomMovementDeciderTest {
    private RandomMovementDeciderImpl movementDecider;

    @BeforeEach
    public void setUp() {
        movementDecider = new RandomMovementDeciderImpl();
    }

    @DisplayName("정책에 맞게 4 이상일 경우 전진으로 판단하는지 Test")
    @Test
    public void decide_ShouldReturnTrue_WhenRandomNumberIsFourOrGreater() {
        int randomNumber = 4;

        boolean result = movementDecider.decide(randomNumber);

        assertThat(result).isTrue();
    }

    @DisplayName("정책에 맞게 4 미만일 경우 전진으로 판단하는지 Test")
    @Test
    public void decide_ShouldReturnFalse_WhenRandomNumberIsLessThanFour() {
        int randomNumber = 3;

        boolean result = movementDecider.decide(randomNumber);

        assertThat(result).isFalse();
    }
}
