package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class InputProcesserTest extends NsTest {

    @Test
    void 자동차_이름_5자_이상_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차의 이름은 5자 이하여야 합니다.")
        );
    }

    @Test
    void 자동차_이름_중복_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 중복될 수 없습니다.")
        );
    }

    @Test
    void 자동차목록_빈문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("아무런 내용이 입력되지 않았습니다."));
    }

    @Test
    void 실행횟수_빈문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("아무런 내용이 입력되지 않았습니다."));
    }

    @Test
    void 숫자가_아닌_실행횟수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "a"))
                        .isInstanceOf(NumberFormatException.class)
                        .hasMessage("숫자를 입력해 주세요."));
    }

    @Test
    void 양수가_아닌_실행횟수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("실행횟수는 양수만 입력 가능합니다."));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}