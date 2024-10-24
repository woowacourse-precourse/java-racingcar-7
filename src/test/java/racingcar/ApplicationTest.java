package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("통합 테스트")
class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("이름 테스트")
    class 이름_테스트 {
        @Test
        void 성공_이름_5글자이하() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 실패_이름_6글자이상() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_이름_비어있음() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 실패_이름_공백() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi, ", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        // TODO : null이 문자열로 입력되어 "null"이 되므로 다른 테스트 방법 찾기
//        @Test
//        void 실패_이름_null() {
//            assertSimpleTest(() ->
//                    assertThatThrownBy(() -> runException(null, "1"))
//                            .isInstanceOf(IllegalArgumentException.class)
//            );
//        }

        @Test
        void 실패_이름_중복() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    @DisplayName("횟수 테스트")
    class 횟수_테스트 {
        @Test
        void 성공_횟수_0() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "0");
                        assertThat(output()).contains("최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 성공_횟수_1() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 성공_횟수_2이상() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "5");
                        assertThat(output())
                                .contains("pobi : -", "woni : ", "jun : -")
                                .contains("pobi : --", "woni : -", "jun : --")
                                .contains("pobi : ---", "woni : --", "jun : ---")
                                .contains("pobi : ----", "woni : ---", "jun : ----")
                                .contains("pobi : -----", "woni : ----", "jun : -----", "최종 우승자 : pobi, jun");
                    },
                    MOVING_FORWARD, STOP, MOVING_FORWARD,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @Test
        void 실패_횟수_음수() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        // TODO : runException은 마지막 인자에 빈 문자열이 들어올 경우 입력값으로 처리되지 않으므로 다른 방법 찾기
//        @Test
//        void 실패_횟수_비어있음() {
//            assertSimpleTest(() ->
//                    assertThatThrownBy(() -> runException("pobi,woni", ""))
//                            .isInstanceOf(IllegalArgumentException.class)
//            );
//        }

        @Test
        void 실패_횟수_공백() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,woni", " "))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        // TODO : null이 문자열로 입력되어 "null"이 되므로 다른 테스트 방법 찾기
//        @Test
//        void 실패_횟수_null() {
//            assertSimpleTest(() ->
//                    assertThatThrownBy(() -> runException("pobi,woni", null))
//                            .isInstanceOf(IllegalArgumentException.class)
//            );
//        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
