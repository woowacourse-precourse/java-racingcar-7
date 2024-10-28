package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

/*
 * 차수 별 실행 결과 출력 기능 테스트 코드 작성
 * 우승자 출력 기능 테스트 코드 작성
 */
class OutputViewTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 차수별_실행결과_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("pobi : -", "woni : ", "pobi : --", "woni : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_한명_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output()).contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_여러명_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}