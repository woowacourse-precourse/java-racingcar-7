package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttemptCountArgumentResolverTest {

    private static final String ERROR_MESSAGE = "숫자로 변환가능한 입력이어야 합니다.";

    AttemptCountArgumentResolver argumentResolver = new AttemptCountArgumentResolver();

    @Test
    @DisplayName("숫자로 변환 불가능 입력이 들어오면 에러 발생")
    void parse_숫자로_변환불가능한_입력_에러발생() {
        // given
        String noIntInput = "a";
        String emptyInput = "";
        String nullInput = null;

        // when & then
        assertThatThrownBy(() -> argumentResolver.parse(noIntInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);

        assertThatThrownBy(() -> argumentResolver.parse(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);

        assertThatThrownBy(() -> argumentResolver.parse(nullInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("overflow 에러 발생")
    void parse_overflow_입력_에러발생() {
        // given
        String overflowInput = "10000000000";

        // when & then
        assertThatThrownBy(() -> argumentResolver.parse(overflowInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("정상 입력이 들어오면 성공")
    void parse_정상입력_성공() {
        // given
        String input = "5";

        // when
        int parsedInt = argumentResolver.parse(input);

        // then
        assertThat(parsedInt).isEqualTo(5);
    }

}