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
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    @DisplayName("자동차 이름 중복 테스트")
    @Test
    void 중복된_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("공백인 자동차 이름 테스트")
    @Test
    void 빈_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("5자가 넘는 자동차 이름 테스트")
    @Test
    void 글자수_제한을_넘는_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobipobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이동 횟수로 숫자가 아닌 값 입력 테스트")
    @Test
    void 숫자가_아닌_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni","abc"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이동 횟수로 빈 값 입력 테스트")
    @Test
    void 빈_값() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni",""))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이동 횟수로 음수 값 입력 테스트")
    @Test
    void 음수_값() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni","-1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("이동 횟수로 int 범위를 넘어서는 값 입력 테스트")
    @Test
    void 범위를_넘어서는_값() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", String.valueOf((long)MAX_VALUE + 1)))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 단일_우승자() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
