package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.common.exception.ErrorMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.exception.RacingCarException;
import racingcar.dto.MovementValue;

class RandomValueGeneratorTest {

    private final RandomValueGenerator randomValueGenerator = new RandomValueGenerator();

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @ParameterizedTest
        @NullSource
        @DisplayName("null 값이 생성될 경우 예외가 발생한다")
        void null_값이_생성될_경우_예외가_발생한다(Integer invalidValue) {
            assertThatThrownBy(() -> {
                if (invalidValue == null) {
                    throw RacingCarException.from(RANDOM_VALUE_GENERATOR_NULL_VALUE);
                }
            }).isInstanceOf(RacingCarException.class)
                    .hasMessage(RANDOM_VALUE_GENERATOR_NULL_VALUE.getMessage());
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 10, 100})
        @DisplayName("생성된 값이 0에서 9 범위를 벗어날 경우 예외가 발생한다")
        void 생성된_값이_범위를_벗어날_경우_예외가_발생한다(int invalidValue) {
            assertThatThrownBy(() -> {
                if (invalidValue < 0 || invalidValue > 9) {
                    throw RacingCarException.from(RANDOM_VALUE_GENERATOR_OUT_OF_RANGE);
                }
            }).isInstanceOf(RacingCarException.class)
                    .hasMessage(RANDOM_VALUE_GENERATOR_OUT_OF_RANGE.getMessage());
        }
    }

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @RepeatedTest(100)
        @DisplayName("MovementValue 객체가 null이 아니어야 한다")
        void MovementValue_객체는_null이_아니어야_한다() {
            MovementValue movementValue = randomValueGenerator.generateMovementValue();
            assertThat(movementValue)
                    .as(RANDOM_VALUE_GENERATOR_NULL_VALUE.getMessage())
                    .isNotNull();
        }

        @RepeatedTest(100)
        @DisplayName("MovementValue 내부 값이 0에서 9 사이의 정수여야 한다")
        void MovementValue_내부_값이_0에서_9_사이의_정수여야_한다() {
            MovementValue movementValue = randomValueGenerator.generateMovementValue();
            assertThat(movementValue.value())
                    .as(RANDOM_VALUE_GENERATOR_OUT_OF_RANGE.getMessage())
                    .isBetween(0, 9);
        }
    }
}
