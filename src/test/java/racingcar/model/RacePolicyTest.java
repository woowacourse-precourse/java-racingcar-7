package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacePolicyTest {
    private RacePolicy racePolicy;

    @BeforeEach
    void setUp() {
        racePolicy = new RacePolicy();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("4이상의 정수를 입력하면 true를 반환한다.")
    void testSatisfiedPolicyCondition(int randomNumber) {
        final boolean result = racePolicy.canMoveForward(randomNumber);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("4미만의 정수를 입력하면 false를 반환한다.")
    void testNotSatisfiedPolicyCondition(int randomNumber) {
        final boolean result = racePolicy.canMoveForward(randomNumber);
        assertThat(result).isFalse();
    }
}
