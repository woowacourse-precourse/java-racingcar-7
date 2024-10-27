package racingcar.support.comparable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("정수 비교 테스트")
class IntegerComparableTest {
    @Test
    @DisplayName("두 정수를 비교한다")
    void 성공_비교() {
        // Given
        IntegerComparable numberComparable = new IntegerComparable();

        // When & Then
        assertThat(numberComparable.meetsThreshold(2, 1)).isTrue();
    }
}
