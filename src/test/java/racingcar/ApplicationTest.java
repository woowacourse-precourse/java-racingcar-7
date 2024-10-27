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
    void 기능_테스트_특수문자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("$jun$,&woni", "1");
                    assertThat(output()).contains("$jun$ : -", "&woni : ", "최종 우승자 : $jun$");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 기능_테스트_공백포함() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("Top G, H R ", "1");
                    assertThat(output()).contains("Top G : -", " H R  : ", "최종 우승자 : Top G");
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
    void 예외_테스트_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("Top P,   ", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_숫자가_아닌_값() {
        assertThatThrownBy(() -> run("pobi,woni", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 형식입니다. 숫자만 입력해주세요.");
    }

    @Test
    void 예외_테스트_음수() {
        assertThatThrownBy(() -> run("pobi,woni", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 형식입니다. 양수를 입력해주세요.");
    }

    @Test
    void 예외_테스트_중복() {
        assertThatThrownBy(() -> run("pobi,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력 형식입니다. 자동차 이름이 중복됩니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
