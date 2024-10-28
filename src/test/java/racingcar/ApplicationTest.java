package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @DisplayName("자동차 이름이 빈 문자열")
    @Test
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름이 공백")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표 앞에 있지만 자동차 이름이 1개")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(", woni ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표 뒤에 있지만 자동차 이름이 1개")
    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("쉼표 없이 자동차 이름이 1개")
    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름 중복")
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름 2개 이상이지만 쉼표 없음")
    @Test
    void 예외_테스트7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi woni jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름 2개 이상이지만 구분자가 쉼표가 아님")
    @Test
    void 예외_테스트8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi. woni. jun", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름에 5자 초과")
    @Test
    void 예외_테스트9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수가 공백")
    @Test
    void 시도횟수_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도횟수가 빈 문자열")
    @Test
    void 시도횟수_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", null))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
