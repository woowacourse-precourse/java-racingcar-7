package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@DisplayName("[TotalRoundsValidator Test]")
public class TotalRoundsValidatorTest {

    @Nested
    @DisplayName("입력값이 공백이 아닌지 검증한다")
    class validateEmptyInputTest {

        @Test
        @DisplayName("정상적인 조건의 시도횟수인 경우 아무것도 하지 않는다.")
        void Given_ValidTotalRounds_When_ValidateEmptyInput_Then_DoNothing() {
            //given
            final String validTotalRounds = "4";

            //when & then
            assertDoesNotThrow(() -> TotalRoundsValidator.validate(validTotalRounds));
        }

        @Test
        @DisplayName("입력값이 공백이면 예외를 던진다.")
        void Given_Empty_When_ValidateInvalidInput_Then_ThrowException() {
            //given
            final String invalidTotalRounds = "";

            //when & then
            assertThatThrownBy(() -> TotalRoundsValidator.validate(invalidTotalRounds));
        }
    }

    @Nested
    @DisplayName("입력값이 유효한 숫자인지 검증한다")
    class validateNumberTest {

        @Test
        @DisplayName("입력값이 숫자가 아니라면 예외를 던진다")
        void Given_NotNumber_When_ValidateNumber_Then_ThrowException() {
            //given
            final String notNumber = "뽀뚜";

            //when & then
            assertThatThrownBy(() -> TotalRoundsValidator.validate(notNumber));
        }

        @Test
        @DisplayName("입력값이 숫자이긴 하나 정수가 아니라면 예외를 던진다")
        void Given_NotInteger_When_ValidateNumber_Then_ThrowException() {
            //given
            final String notInteger = "1.1";

            //when & then
            assertThatThrownBy(() -> TotalRoundsValidator.validate(notInteger));
        }

        @Test
        @DisplayName("입력값이 정수이긴 하나 양수가 아닌 경우 예외를 던진다")
        void Given_NotPositiveInteger_When_ValidateNumber_Then_ThrowException() {
            //given
            final String notPositiveInteger = "-1";

            //when & then
            assertThatThrownBy(() -> TotalRoundsValidator.validate(notPositiveInteger));
        }

        @Test
        @DisplayName("입력값이 양수인 정수인 경우 아무것도 하지 않는다")
        void Given_PositiveInteger_When_ValidateNumber_Then_DoNothing() {
            //given
            final String validPositiveInteger = "1";

            //when & then
            assertDoesNotThrow(() -> TotalRoundsValidator.validate(validPositiveInteger));
        }

    }
}
