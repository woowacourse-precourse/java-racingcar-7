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
    void 우승자_한명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_여러명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름_5자_초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,jabajs", "3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
        });
    }

    @Test
    void 이름_빈칸() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi, ", "3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("빈 칸 혹은 공백은 사용이 불가합니다.");
        });
    }

    @Test
    void 이름_중복() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,pobi", "3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 자동차 이름입니다.");
        });
    }

    @Test
    void 특수기호_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,jam*", "2"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("특수기호는 사용이 불가합니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
