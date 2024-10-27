package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {

    private TryNumber tryNumber;

    @BeforeEach
    void setUp() {
        tryNumber = new TryNumber();
    }

    @Test
    void 시도할_횟수_유효성_테스트() {
        // 숫자가 아닌 문자열 "as"를 설정하여 예외가 발생하는지 테스트
        assertThatThrownBy(() -> tryNumber.setTryNumber("as"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 숫자를 입력해야 합니다."); // 예외 메시지 추가 (필요 시 변경)
    }
}
