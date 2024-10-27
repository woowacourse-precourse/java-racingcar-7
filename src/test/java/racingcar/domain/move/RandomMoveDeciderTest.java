package racingcar.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.randomGenerator.RandomNumberGenerator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveDeciderTest {
    private static final int MOVE_THRESHOLD = 4;

    @ParameterizedTest
    @DisplayName(MOVE_THRESHOLD + "보다 작으면 false를 반환하는지 확인")
    @MethodSource("generateLessThanThreshold")
    void testNotMoveLessThanThreshold(RandomNumberGenerator randomNumberGenerator) {
        RandomMoveDecider randomMoveDecider = new RandomMoveDecider(randomNumberGenerator);
        boolean actual = randomMoveDecider.canMove();

        assertThat(actual).isFalse();
    }

    private static Stream<Arguments> generateLessThanThreshold() {
        return Stream.of(
                Arguments.of(generateOnly(MOVE_THRESHOLD - 1)),
                Arguments.of(generateOnly(0))
        );
    }

    @ParameterizedTest
    @DisplayName(MOVE_THRESHOLD + "보다 크거나 같으면 true를 반환하는지 확인")
    @MethodSource("generateGreaterOrEqualThanThreshold")
    void testMoveGreaterOrEqualThanThreshold(RandomNumberGenerator numberGenerator) {
        RandomMoveDecider randomMoveDecider = new RandomMoveDecider(numberGenerator);
        boolean actual = randomMoveDecider.canMove();

        assertThat(actual).isTrue();
    }

    private static Stream<Arguments> generateGreaterOrEqualThanThreshold() {
        return Stream.of(
                Arguments.of(generateOnly(MOVE_THRESHOLD)),
                Arguments.of(generateOnly(5))
        );
    }

    private static RandomNumberGenerator generateOnly(int number) {
        return () -> number;
    }
}