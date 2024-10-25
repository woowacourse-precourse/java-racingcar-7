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
    void 자동차_이름이_비어있을_때_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 비어있을 수 없습니다.")
        );
    }

    @Test
    void 자동차_이름이_2개_미만일_때_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최소 2대 이상의 자동차 이름을 입력해야 합니다.")
        );
    }


    @Test
    void 자동차_이름이_중복될_때_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 중복될 수 없습니다")
        );
    }

    @Test
    void 시도_횟수가_정수가_아닐_때_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "3.2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 정수여야 합니다.")
        );
    }

    @Test
    void 시도_횟수가_0이하일_때_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.")
        );
    }

    @Test
    void 공동_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
