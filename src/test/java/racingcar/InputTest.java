package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class InputTest extends NsTest {
    @Test
    void 자동차이름_성공_테스트() {
        assertSimpleTest(() ->
                runException("핍비,피비", "1")
        );
    }

    @Test
    void 자동차이름_공백_입력_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_중복_이름_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("핍비,핍비", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_공백_포함_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",다섯글자초과", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_길이_초과_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("다섯글자초과,둘다다섯글자초과", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차이름_특수문자_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("네글자임,다섯글자초과!@#!$@", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수_성공_테스트() {
        assertSimpleTest(() ->
                runException("핍비,피비", "4")
        );
    }

    @Test
    void 이동횟수_음수_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("핍비,피비", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수_문자열_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("핍비,피비", "문자열"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이동횟수_실수_성공_테스트() {
        assertSimpleTest(() ->
                runException("핍비,피비", "1.0")
        );
    }

    @Test
    void 이동횟수_실수_실패_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("핍비,피비", "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
