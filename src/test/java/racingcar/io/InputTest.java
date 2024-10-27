package racingcar.io;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @Test
    void 구분자가콤마아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi;javaj", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이없는경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름에공백이포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java ", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이중복되는경우(){
        assertSimpleTest(()->
                assertThatThrownBy(() -> runException("pobi,pobi","3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 레이스횟수가문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "A"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 레이스횟수가문자열(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "ABC"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
