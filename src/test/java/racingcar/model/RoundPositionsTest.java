package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RoundPositionsTest {

    @DisplayName("각 자동차의 포지션을 저장한다")
    @ParameterizedTest
    @MethodSource("providePositions")
    void roundPositionsStoresPositions(List<Integer> positions) {
        RoundPositions roundPositions = new RoundPositions(positions);
        assertThat(roundPositions.positions()).isEqualTo(positions);
    }

    static Stream<Arguments> providePositions() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(0, 1, 2)),
                Arguments.of(List.of(5, 3, 8))
        );
    }
}
