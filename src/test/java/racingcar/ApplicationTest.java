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
    void 자동차_이름_5자_초과_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("car123,carB,carC"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5글자 이하여야 합니다.");
        });
    }

    @Test
    void 자동차_이름_중복_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB,carA"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
        });
    }

    @Test
    void 자동차_이름_공백_예외1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,,carB"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
        });
    }

    @Test
    void 자동차_이름_공백_예외2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA, ,carB"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
        });
    }

    @Test
    void 자동차_이름_공백_예외3() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("\n"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 공백이 될 수 없습니다.");
        });
    }


    @Test
    void 반복_횟수_숫자가_아닌_문자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB", "abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 숫자여야 합니다.");
        });
    }

    @Test
    void 반복_횟수_공백_입력_예외1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB", "\n"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 숫자여야 합니다.");
        });
    }

    @Test
    void 반복_횟수_공백_입력_예외2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB", " "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 숫자여야 합니다.");
        });
    }

    @Test
    void 반복_횟수_음수_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB", "-3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 1 이상의 양의 정수여야 합니다.");
        });
    }

    @Test
    void 반복_횟수_제로_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("carA,carB", "0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 1 이상의 양의 정수여야 합니다.");
        });
    }

    @Test
    void 반복_횟수_INT_MAX_초과_예외() {
        assertSimpleTest(() -> {
            String input = String.valueOf((long) Integer.MAX_VALUE + 1);
            assertThatThrownBy(() -> runException("carA,carB", input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("반복 횟수는 int의 최대값을 초과할 수 없습니다.");
        });
    }

    @Test
    void 자동차_전진_조건_충족시_이동() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("carA", "1");
                    assertThat(output()).contains("carA : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_멈춤_조건_충족시_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("carA", "1");
                    assertThat(output()).contains("carA : ");
                },
                STOP
        );
    }

    @Test
    void 우승자_한명_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_여러명_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("최종 우승자 : pobi, jun");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 모든_자동차_이동하지_않을_때_우승자_결정() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("carA,carB", "1");
                    assertThat(output()).contains("최종 우승자 : carA, carB");
                },
                STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
