package racingcar.Validator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest extends NsTest {

    @Test
    void 이름_길이에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pppppp,pobi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_중복에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi,woni"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수가_음수인_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woni,pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수가_0인_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woni,pobi", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동_횟수가_문자로_입력된_경우에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("woni,pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
