package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExecptionTest extends NsTest {

    @Test
    void 자동차_이름_입력_값이_없을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_입력_값이_없을_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("seop", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_양수가_아닐_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("seop", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_5자_이하가_아닐_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("seopppp", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_1자_이상이_아닐_때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("seop,,jungi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
