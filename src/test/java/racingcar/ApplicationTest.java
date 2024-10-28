package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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

    @Nested
    class 입력_테스트 {

        @Nested
        class 자동차_이름 {

            @Test
            void 공백_입력시_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc,,d"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            void 이름_5자_초과시_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abcdefg"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

        }

        @Nested
        class 이동_횟수 {

            @Test
            void 공백_입력시_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", " "))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            void 숫자가_아닐_경우_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            void 음수일_경우_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "-10"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            void 범위_보다_클_경우_예외() {
                assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "999999999999999999999999999999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                );
            }

        }
    }

    @Nested
    class 기능_테스트 {

        @Test
        void 단일_우승자() {
            String expected = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 횟수는 몇 회인가요?
                
                실행 결과
                pobi : -
                woni :\s
                
                최종 우승자 : pobi""";

            assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(expected);
                },
                MOVING_FORWARD, STOP
            );
        }

        @Test
        void 공동_우승자() {
            String expected = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 횟수는 몇 회인가요?
                
                실행 결과
                pobi : -
                woni :\s
                jun : -
                
                pobi : --
                woni : -
                jun : --
                
                pobi : ---
                woni : --
                jun : ---
                
                pobi : ----
                woni : ---
                jun : ----
                
                pobi : -----
                woni : ----
                jun : -----
                
                최종 우승자 : pobi, jun""";

            assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "5");
                    assertThat(output()).isEqualTo(expected);
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            );
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
