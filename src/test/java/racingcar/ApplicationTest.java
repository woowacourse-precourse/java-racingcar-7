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
    void 자동차_목록_입력_테스트() {
        run("pobi,woni,java", "1");
        assertThat(output()).contains("pobi", "woni", "java");
    }

    @Test
    void 시도_횟수_입력_테스트() {
        int attemptCount = 5;
        run("pobi,woni,jun", String.valueOf(attemptCount));

        int roundCount = 0;
        String[] lines = output().split("\n");

        for (String line : lines) {
            if (line.contains("pobi :") || line.contains("woni :") || line.contains("jun :")) {
                roundCount++;
            }
        }

        int calculatedRoundCount = roundCount / 3;

        assertThat(calculatedRoundCount).isEqualTo(attemptCount);
    }

    @Test
    void 이동거리_계산_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");  // 총 3회 시도

                    // 이동 여부에 따라 예상 출력
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : ",
                            "pobi : --",
                            "woni : -",
                            "pobi : ---",
                            "woni : -"
                    );
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_선정_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,java", "1");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
