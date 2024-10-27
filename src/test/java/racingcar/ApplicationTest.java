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
    void 동점_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
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
    void 빈_자동차_이름_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 비어 있을 수 없으며 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 잘못된_경주_횟수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni, java", "kk"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("잘못된 값을 입력하였습니다.")
        );
    }

    @Test
    void 경주_횟수_0_이하_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("경주 횟수는 1 이상의 숫자여야 합니다.")
        );
    }

    @Test
    void 경주_횟수_1000_초과_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1001"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("최대 경주 횟수(1000회)를 벗어났습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
