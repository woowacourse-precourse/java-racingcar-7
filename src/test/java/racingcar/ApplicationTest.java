package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 글자_초과_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.")
        );
    }

    @Test
    void null_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(null, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름에 null이 포함되어 있습니다.")
        );
    }

    @Test
    void 빈_문자열_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어 있습니다.")
        );
    }

    @Test
    void 중복_이름_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 있습니다.")
        );
    }

    @Test
    void 시도_횟수_음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 시도_횟수_숫자_아님_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 숫자가 입력되었습니다.")
        );
    }

    @Test
    void 쉼표_사이에_공백_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi, ,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 비어 있습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}