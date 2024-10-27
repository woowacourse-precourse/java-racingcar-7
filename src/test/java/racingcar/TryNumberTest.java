package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class TryNumberTest {

    private TryNumber tryNumber;

    @BeforeEach
    void setUp() {
        tryNumber = new TryNumber();
    }

    @Test
    void 시도할_횟수_유효성_테스트() {
        // 음수를 설정하여 예외 발생 테스트
        assertThatThrownBy(() -> tryNumber.setTryNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0 이상의 숫자여야 합니다."); // 음수에 대한 예외 메시지 확인

        // 숫자가 아닌 문자열을 설정하여 예외 발생 테스트
        assertThatThrownBy(() -> tryNumber.setTryNumber("as"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRY_NUM_NOT_DIGIT_ERROR.print()); // 숫자가 아닌 경우 예외 메시지 확인

        // null 값 설정 시 예외 발생 테스트
        assertThatThrownBy(() -> tryNumber.setTryNumber(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRY_NUM_NULL_ERROR.print()); // null 값 예외 메시지 확인

        // 빈 문자열 설정 시 예외 발생 테스트
        assertThatThrownBy(() -> tryNumber.setTryNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.TRY_NUM_NULL_ERROR.print()); // 빈 문자열 예외 메시지 확인
    }

    @Test
    void 올바른_시도횟수_설정_테스트() {
        tryNumber.setTryNumber("3"); // 올바른 숫자 문자열 설정
        assertThat(tryNumber.getTryNumber()).isEqualTo(3); // 시도 횟수가 3인지 확인
    }
}
