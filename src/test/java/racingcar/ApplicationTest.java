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
    void 여러대의_자동차_다중_시도_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "pobi : -",  // 1차 시도
                            "woni : -",  // 1차 시도
                            "jun : ",    // 1차 시도

                            "pobi : --", // 2차 시도
                            "woni : --", // 2차 시도
                            "jun : -",   // 2차 시도

                            "pobi : ---",// 3차 시도
                            "woni : ---",// 3차 시도
                            "jun : --",  // 3차 시도
                            "최종 우승자 : pobi, woni" // 공동 우승자
                    );
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, // 1차 시도 (pobi: 전진, woni: 전진, jun: 멈춤)
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // 2차 시도 (모두 전진)
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD  // 3차 시도 (모두 전진)
        );
    }

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
    void 빈_문자열_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,jun", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
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
    void 시도_횟수_음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.")
        );
    }

    @Test
    void 시도_횟수_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,jun", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("올바른 숫자를 입력하세요.")
        );
    }

    @Test
    void 특수문자_포함_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,@woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("특수문자는 허용되지 않습니다.")
        );
    }

    @Test
    void 자동차_이름_길이_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,longname", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.")
        );
    }

    @Test
    void 단일_자동차_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("solo", "3");
                    assertThat(output()).contains("solo : -", "최종 우승자 : solo");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
