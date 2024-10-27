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

    @DisplayName("공동 우승자 검증 테스트1")
    @Test
    void 기능_테스트2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,seo", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "seo : ",
                            "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @DisplayName("공동 우승자 검증 테스트2")
    @Test
    void 기능_테스트3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,seo", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "seo : -",
                            "최종 우승자 : pobi, woni, seo");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("하이픈(-)이 포함된 입력)")
    @Test
    void 기능_테스트4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("P-1,P-911", "1");
                    assertThat(output()).contains("P-1 : -", "P-911 : -",
                            "최종 우승자 : P-1, P-911");
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

    @DisplayName("시도할 횟수에 숫자가 아닌 다른 값을 입력한 경우 예외 테스트")
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,seo", "n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("특수문자가 포함된 입력 예외 테스트(하이픈(-) 제외)")
    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("po[],seo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
