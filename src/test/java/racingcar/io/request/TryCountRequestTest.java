package racingcar.io.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class TryCountRequestTest {

    @DisplayName("시도 횟수는 숫자 형식이어야 한다.")
    @Test
    void parseInt() {
        TryCountRequest request = new TryCountRequest("1");

        assertThat(request.tryCount()).isEqualTo(1);
    }

    @DisplayName("숫자 형식이 아닌 문자열이 입력되면 예외를 던진다.")
    @Test
    void inputIsNotNumberFormatThenThrowException() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new TryCountRequest("a"))
            .withMessage("시도 횟수는 숫자여야 합니다.");
    }

    @DisplayName("시도 횟수는 1 이상이어야 한다.")
    @Test
    void validateCount() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new TryCountRequest("0"))
            .withMessage("시도 횟수는 1 이상이어야 합니다.");
    }

}