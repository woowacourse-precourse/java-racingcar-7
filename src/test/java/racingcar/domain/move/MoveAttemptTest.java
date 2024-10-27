package racingcar.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveAttemptTest {
    @ParameterizedTest
    @DisplayName("자연수로 생성하지 않으면 IllegalArgumentException을 반환하는지 확인")
    @MethodSource("generateIllegalAttemptString")
    void testNotNaturalNumberThrowIllegalArgumentException(String inputString) {
        assertThatThrownBy(() -> MoveAttempt.of(inputString)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateIllegalAttemptString() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("0"),
                Arguments.of("-1"),
                Arguments.of("a")
        );
    }

    @Test
    @DisplayName("생성시 사용한 문자열과 같은 자연수를 반환하는지 확인")
    void testGetCount() {
        String inputString = "1";
        int expected = Integer.parseInt(inputString);

        int actual = MoveAttempt.of(inputString).getCount();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("생성시 사용한 문자열이 같으면 equals를 true로 반환하는지 확인")
    void testEquals() {
        String sameString = "1";
        MoveAttempt moveAttempt = MoveAttempt.of(sameString);
        MoveAttempt anotherMoveAttempt = MoveAttempt.of(sameString);

        assertThat(moveAttempt).isEqualTo(anotherMoveAttempt);
    }

    @Test
    @DisplayName("생성시 사용한 문자열이 같으면 같은 hashcode를 반환하는지 확인")
    void testHashCode() {
        String sameString = "1";
        MoveAttempt moveAttempt = MoveAttempt.of(sameString);
        MoveAttempt anotherMoveAttempt = MoveAttempt.of(sameString);

        assertThat(moveAttempt).hasSameHashCodeAs(anotherMoveAttempt);
    }
}