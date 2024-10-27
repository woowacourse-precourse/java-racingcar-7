package racingcar.support.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 정수 생성 테스트")
class RandomIntegerGeneratorTest {

    @Test
    @DisplayName("정해진 범위 내에서 랜덤값을 생성한다")
    void 성공_랜덤값생성() {
        // Given
        int startInclusive = 0;
        int endInclusive = 9;
        RandomIntegerGenerator randomNumberGenerator = new RandomIntegerGenerator(startInclusive, endInclusive);

        // When
        Integer number = randomNumberGenerator.pickNumber();

        // Then
        assertThat(number).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
