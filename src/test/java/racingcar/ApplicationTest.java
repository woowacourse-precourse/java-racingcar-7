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
    void 시도_횟수가_2이상인_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 빈_입력값_예외_테스트() {
        // 빈 이름 입력에 대해 예외가 발생하는지 검증
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("빈 입력 오류");
        });
    }

    @Test
    void 시도_횟수_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도횟수가 0 이하");
        });
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,crong", "3");
                    assertThat(output()).contains("pobi : --", "woni : --", "crong : --", "최종 우승자 : pobi, woni, crong");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    void 중복_이름_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,pobi,woni", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름 중복 오류");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
