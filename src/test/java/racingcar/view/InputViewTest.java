package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class InputViewTest extends NsTest {
    @Test
    void 자동차_이름이_공백일_때_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.")
        );
    }

    @Test
    void 횟수_공백_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("게임 횟수는 공백이 될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
