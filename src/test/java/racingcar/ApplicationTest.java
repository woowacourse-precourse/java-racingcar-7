package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 예외_테스트_자동차_이름_입력없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 없습니다.")
        );
    }

    @Test
    void 예외_테스트_자동차_이름수_미달() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(",yunju", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차의 이름은 한 글자 이상만 가능합니다.")
        );
    }

    @Test
    void 예외_테스트_자동차_이름수_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,leeyunju", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차의 이름은 다섯 글자 이하만 가능합니다.")
        );
    }

    @Test
    void 예외_테스트_시도횟수_정수가_아닌_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,yunju", "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 띄어쓰기 없는 정수로 입력해주세요.")
        );
    }

    @Test
    void 예외_테스트_시도횟수_미달() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,yunju", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 0회 이상 가능합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
