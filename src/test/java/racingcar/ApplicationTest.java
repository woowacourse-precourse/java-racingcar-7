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
    void 우승자가_여려_명일_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains("pobi : ---", "woni : ---", "jun : ---",
                                                    "최종 우승자 : pobi, woni, jun");
                },
                4, 4
        );
    }

    @Test
    void 자동차_이름을_입력하지_않을_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 자동차_이름을_하나만_입력할_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi", "5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수를_입력하지_않을_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni,juni", "\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수가_0일_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni,juni", "0"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수가_음수일_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni,juni", "-5"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도_횟수에_숫자가_아닌_값을_입력할_경우_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni,juni", "bbb"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
