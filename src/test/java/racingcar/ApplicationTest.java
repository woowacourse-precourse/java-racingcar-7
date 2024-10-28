package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("예외_테스트_빈_자동차_이름")
    void emptyCarNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름을 입력해야 합니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_공백_자동차_이름")
    void spaceCarNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ,pobi,java", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 1자 이상 5자 이하여야 합니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_이름_길이_초과")
    void overCarNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름은 1자 이상 5자 이하여야 합니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_중복_자동차_이름")
    void duplicateCarNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("자동차 이름이 중복될 수 없습니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_빈_이동_횟수")
    void emptyMoveCountException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이동 횟수를 입력해야 합니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_비숫자_이동_횟수")
    void invalidMoveCountException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "five"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이동 횟수는 숫자여야 합니다.")
        );
    }

    @Test
    @DisplayName("예외_테스트_음수_이동_횟수")
    void minusMoveCountException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("이동 횟수는 음수가 될 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
