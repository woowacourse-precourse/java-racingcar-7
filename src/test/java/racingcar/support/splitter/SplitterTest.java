package racingcar.support.splitter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidDelimiterException;

@DisplayName("Splitter 테스트")
class SplitterTest {
    @Nested
    @DisplayName("Splitter 생성 테스트")
    class Splitter_생성 {
        @Test
        @DisplayName("유효한 구분자이면 성공적으로 생성한다")
        void 성공_Splitter생성_유효한구분자() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Splitter(",");
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("구분자가 null이면 예외가 발생한다")
        void 실패_Splitter생성_null() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Splitter(null))
                    .isExactlyInstanceOf(InvalidDelimiterException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자는 null이거나 빈 값일 수 없습니다.");
        }

        @Test
        @DisplayName("구분자가 비어있으면 예외가 발생한다")
        void 실패_Splitter생성_empty() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Splitter(""))
                    .isExactlyInstanceOf(InvalidDelimiterException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자는 null이거나 빈 값일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("Splitter 생성 테스트")
    class 문자열_구분 {
        @Test
        @DisplayName("문자열을 구분한다")
        void 성공_구분() {
            // Given
            String delimiter = ",";
            Splitter splitter = new Splitter(delimiter);
            String text = "mint,dobby";

            // When
            String[] names = splitter.splitFrom(text);

            // Then
            assertAll(
                    () -> assertThat(names[0]).isEqualTo("mint"),
                    () -> assertThat(names[1]).isEqualTo("dobby")
            );
        }
    }
}
