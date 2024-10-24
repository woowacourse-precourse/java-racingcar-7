package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("경주할 자동차의 이름은 문자와 쉼표 이외의 값을 가질 수 없다")
    void 자동차이름_문자와쉼표이외의값_존재() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi@juni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("쉼표(,)로 구분했을 때 자동차 이름이 존재해야 한다")
    void 자동차이름_존재하지_않을때() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi, ,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름은 1자 이상 5자 이하여야 한다")
    void 자동차이름길이() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobijjang,juni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차의 이름은 같을 수 없다")
    void 자동차이름동일여부() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수는 숫자로 이루어져야 한다")
    void 시도횟수_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,juni", "aa"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도 횟수는 필수로 입력되어야 한다")
    void 시도횟수_입력여부() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,juni", "\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
