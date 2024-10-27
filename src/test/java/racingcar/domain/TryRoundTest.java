package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TryRoundTest {

    @Nested
    @DisplayName("시도 횟수 생성 테스트")
    class whenCreateTryRound {

        @ParameterizedTest
        @CsvSource({"1", "22", "333", "4444", "55555", "666666", "7777777", "88888888", "999999999"})
        @DisplayName("양수가 들어오면 정상적으로 생성된다.")
        void successfullyCreateTryRound(String input) {
            //given
            //when then
            assertDoesNotThrow(() -> new TryRound(input));
        }

        @Nested
        @DisplayName("tryRound 생성 실패 테스트")
        class whenContainNonNumber {

            @Test
            @DisplayName("문자를 포함하고 있으면 예외를 발생한다.")
            void throwsExceptionWhenContainNonNumber() {
                //given
                String input = "-123";
                //when then
                assertThatThrownBy(() -> new TryRound(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("양수만 입력해야 합니다.");
            }

            @Test
            @DisplayName("변환한 숫자가 양수가 아니라면 예외를 발생한다.")
            void throwsExceptionWhenIsNotPositiveNumber() {
                //given
                String input = "0";
                //when then
                assertThatThrownBy(() -> new TryRound(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("양수만 입력해야 합니다.");
            }

            @Test
            @DisplayName("양수의 범위를 넘어가는 경우 예외가 발생한다.")
            void throwsExceptionWhenOverInteger() {
                //given
                String input = "9999999999";

                //when then
                assertThatThrownBy(() -> new TryRound(input))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Test
    @DisplayName("finalRound가 3일 때, 생성 후와 1번째 2번째는 flase를 반환하고, 3번째는 true를 반환한다.")
    void returnTrueWhenFinalRound3EqualCurrentRound() {
        //given
        String finalRound = "3";
        TryRound tryRound = new TryRound(finalRound);
        //when
        assertAll(
            () -> assertThat(tryRound.isNotFinish()).isEqualTo(true),
            () -> {
                tryRound.moveToNextRound();
                assertThat(tryRound.isNotFinish()).isEqualTo(true);
            },
            () -> {
                tryRound.moveToNextRound();
                assertThat(tryRound.isNotFinish()).isEqualTo(true);
            },
            () -> {
                tryRound.moveToNextRound();
                assertThat(tryRound.isNotFinish()).isEqualTo(false);
            }
        );
    }
}
