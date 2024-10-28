package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

// 예외처리와 관련된 테스트 코드 작성
class InputViewTest extends NsTest {

    @Test
    @DisplayName("횟수에 자연수가 아닌 값이 들어갔을 때 예외 처리한다.")
    void 횟수_자연수_아닐때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "5.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("횟수에 숫자가 아닌 값이 들어갔을 때 예외 처리한다.")
    void 횟수_숫자_아닐때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "aaa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}