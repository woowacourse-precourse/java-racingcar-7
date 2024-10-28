package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest extends NsTest {

    @Test
    void 자동차_이름_기본_테스트() {
        assertSimpleTest(() -> {
            run("pobi,crong,honux", "1");
            assertThat(output()).contains("pobi", "crong", "honux");
        });
    }

    @Test
    void 빈문자열_자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 초과된_길이의_자동차_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaaaaa", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_기본_테스트() {
        assertSimpleTest(() -> {
            run("pobi,crong,honux", "1");
            assertThat(output()).contains("실행 결과");
        });
    }

    @Test
    void 시도_횟수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,crong,honux", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
