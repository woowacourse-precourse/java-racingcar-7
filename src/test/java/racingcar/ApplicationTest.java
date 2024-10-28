package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Controller.Application;
import racingcar.Service.RacingGame;
import racingcar.Utils.ApplicationConstants;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                ApplicationConstants.MOVE_THRESHOLD, ApplicationConstants.MOVE_THRESHOLD - 1
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                ApplicationConstants.MOVE_THRESHOLD, ApplicationConstants.MOVE_THRESHOLD, ApplicationConstants.MOVE_THRESHOLD
        );
    }

    @Test
    void 시도_횟수_유효하지_않은_입력_예외_테스트() {
        assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ApplicationConstants.INVALID_ATTEMPT_COUNT_MESSAGE);
    }

    @Test
    void 예외_테스트() {
        assertThatThrownBy(() -> runException("pobi,javaji,tooLongName", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ApplicationConstants.CAR_NAME_VALIDATION_MESSAGE);
    }

    @Test
    void 자동차_이동_상태_확인_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    String outputResult = output();
                    assertThat(outputResult).contains("pobi", "woni");
                    assertThat(outputResult).containsPattern("pobi : (-+)*");
                    assertThat(outputResult).containsPattern("woni : (-+)*");
                },
                ApplicationConstants.MOVE_THRESHOLD, ApplicationConstants.MOVE_THRESHOLD - 1, ApplicationConstants.MOVE_THRESHOLD
        );
    }

    private void runException(String carNames, String attempts) {
        run(carNames, attempts);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
