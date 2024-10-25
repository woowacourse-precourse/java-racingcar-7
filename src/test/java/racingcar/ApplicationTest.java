package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.util.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final String CARS = "KIA,HONDA,BMW";


    @Test
    void 경주_단수_우승자_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run(CARS, "2");
                assertThat(output()).contains("KIA : --", "HONDA : ", "BMW : -", "최종 우승자 : KIA");
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 경주_복수_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(CARS, "2");
                    assertThat(output()).contains("KIA : --", "HONDA : ", "BMW : --", "최종 우승자 : KIA, BMW");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_이름_자리수_5초과_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(CARS+"FERRARI", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CAR_NAME_LESS_THAN_FIVE.getMessage())
        );
    }

    @Test
    void 자동차_이름_빈칸_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS + ", ,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_CAN_NOT_BLANK_OR_EMPTY.getMessage())
        );
    }

    @Test
    void 자동차_이름_공백_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS + ",,FERRARI", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_CAN_NOT_BLANK_OR_EMPTY.getMessage())
        );
    }

    @Test
    void 자동차_이름_중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS + ",KIA", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CAR_NAME_DUPLICATED.getMessage() + "KIA")
        );
    }

    @Test
    void 시도_회수_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS, "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.TRY_NUMBER_MORE_THAN_ZERO.getMessage())
        );
    }

    @Test
    void 시도_회수_문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(CARS, "a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.TRY_NUMBER_NOT_NUMBER.getMessage() + "a")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
