package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class 우승자_출력 {
        @Test
        void 기능_테스트_단독_우승() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 기능_테스트_공동_우승() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @Test
        void 공동_우승자_출력이_성공한다() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "1");
                        assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                    },
                    MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }

        @Test
        void 공동_우승자_출력이_성공한다2() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni,jun", "1");
                        assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni");
                    },
                    MOVING_FORWARD, MOVING_FORWARD, STOP
            );
        }
    }

    @Nested
    class 구분자_예외 {
        @Test
        void 구분자가_연속해서_나오는_경우_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("na0th,,geon", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 구분자의_앞뒤로_이름이_없는_경우_예외_발생1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",geon", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 구분자의_앞뒤로_이름이_없는_경우_예외_발생2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("geon,", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 구분자만_나온_경우() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(",", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }

    @Nested
    class 이름_예외 {
        @Test
        void 중복된_이름의_경우_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,pobi", "10"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 이름이_5글자를_초과하면_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 이름에_공백이_포함된_경우_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("geon, na0th", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 자동차가_2대_미만인_경우_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("geon", "1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

    }

    @Nested
    class 이동_횟수_입력_테스트 {
        @Test
        void 이동_횟수가_양의_정수인_경우_테스트는_정상_입력() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("pobi,woni", "1");
                        assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                    },
                    MOVING_FORWARD, STOP
            );
        }

        @Test
        void 이동_횟수가_0인_경우_테스트_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "0"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 이동_횟수가_빈_문자인_경우_테스트_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "\\n"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 이동_횟수가_음수인_경우_테스트_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "-1"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 이동_횟수가_문자인_경우_테스트_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,java", "a"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        void 너무_많은_이동_횟수_입력은_예외_발생() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("geon, na0th", "9999999"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }


    @Test
    void 아무_입력도_없는_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n", "\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
