package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

class CustomApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승자_2명_이상_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("lee,   dong  ,   chan", "4");

                    // 기대되는 출력 값 확인
                    assertThat(output()).contains(
                            "lee : -", "dong : ", "chan : ",
                            "lee : -", "dong : -", "chan : -",
                            "lee : --", "dong : -", "chan : --",
                            "lee : ---", "dong : --", "chan : ---",
                            "최종 우승자 : lee, chan"
                    );
                },
                MOVING_FORWARD, STOP, STOP, // 1라운드
                STOP, MOVING_FORWARD, MOVING_FORWARD, // 2라운드
                MOVING_FORWARD, STOP, MOVING_FORWARD, // 3라운드
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD // 4라운드
        );
    }

    @Test
    void 빈_자동차_이름_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,  ,java", "1"))
                        .isInstanceOf(RacingCarException.class)
                        .hasMessage(ErrorMessage.EMPTY_CAR_NAME.getMessage())
        );
    }

    @Test
    void 자동차_이름_중복시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,kkk,java,kkk", "1"))
                        .isInstanceOf(RacingCarException.class)
                        .hasMessage(ErrorMessage.DUPLICATED_CAR_NAME.getMessage())
        );
    }

    @Test
    void 빈_입력시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
