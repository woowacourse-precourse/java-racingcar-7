package racingcar.integrationtest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("게임이 정상적으로 실행되고 결과가 출력되는지 통합 테스트")
    void gameIntegrationTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,crong", "3");
                    assertThat(output()).contains(
                            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                            "시도할 횟수는 몇 회인가요?",
                            "실행 결과",
                            "최종 우승자 : pobi"
                    );
                },
                // 각 시도마다 랜덤 값 설정
                MOVING_FORWARD, STOP, STOP,   // 1회차: pobi 전진, woni 정지, crong 정지
                MOVING_FORWARD, STOP, STOP,   // 2회차: pobi 전진, woni 정지, crong 정지
                STOP, STOP, STOP              // 3회차: 모두 정지
        );
    }

    @Test
    @DisplayName("잘못된 입력 시 예외가 발생하고 프로그램이 종료되는지 통합 테스트")
    void gameIntegrationTest_withInvalidInput_shouldThrowException() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("pobi,crong,honux", "-1"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 양의 정수여야 합니다");
            assertThat(output()).contains(
                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                    "시도할 횟수는 몇 회인가요?"
            );
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
