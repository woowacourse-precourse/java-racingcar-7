
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
    void 자동차_이름_및_시도_횟수_입력_테스트() {
        assertSimpleTest(() -> {
            run("pobi,woni,javaj", "3");
            assertThat(output()).contains("pobi", "woni", "javaj");
        });
    }
    
    @Test
    void 자동차_전진_정지_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ");
            },
            MOVING_FORWARD, STOP
        );
    }
    
    @Test
    void 최종_우승자_출력_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,javaj", "3");
                assertThat(output()).contains("최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_처리_테스트_자동차_이름() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,javajig,javajig", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하로 하세요.");
        });
    }
    
    @Test
    void 예외_처리_테스트_시도_횟수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수를 양의 정수로 입력하세요");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
