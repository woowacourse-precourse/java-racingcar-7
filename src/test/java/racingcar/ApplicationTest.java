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
    void 공동우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "최종 우승자 : pobi, woni, jun"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 차량이름_중복_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복된 자동차 이름이 있습니다")
        );
    }

    @Test
    void 숫자_특수문자_이름_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,123", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 알파벳만 포함할 수 있습니다.")
        );
    }

    @Test
    void 공백이_포함된_이름_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, woni,jun", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("차량 이름에 공백이 포함될 수 없습니다.");
        });
    }

    @Test
    void 차량이_한_대만_있을_때_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름을 최소 2개 입력해주세요.");
        });
    }

    @Test
    void 이동_횟수가_1_미만일_때_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
        });
    }

    @Test
    void 빈_이름과_빈_시도횟수_입력_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("", ""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름을 최소 2개 입력해주세요.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
