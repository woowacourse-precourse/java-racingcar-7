package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.util.ConstOutputMessage.EXECUTION_RESULT;
import static racingcar.util.ConstOutputMessage.FINAL_WINNER;
import static racingcar.util.ConstOutputMessage.INPUT_CAR_NAME;
import static racingcar.util.ConstOutputMessage.INPUT_TURN_COUNT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.EmptyInputException;
import racingcar.exception.InvalidCharacterException;
import racingcar.exception.InvalidCarNameLengthException;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidRegisterCarsInputLengthException;
import racingcar.exception.NumberRangeException;

public class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains(
                            INPUT_CAR_NAME.getMessage(),
                            INPUT_TURN_COUNT.getMessage(),
                            EXECUTION_RESULT.getMessage(),
                            "pobi : -",
                            "woni : ",
                            FINAL_WINNER.getMessage()+"pobi"
                    );
                },
                MOVING_FORWARD, STOP
        );
    }

    @Nested
    @DisplayName("자동차 등록 테스트")
    class CarRegistExceptionTests {

        @Test
        void 입력값_길이_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("o".repeat(1001), "1"))
                            .isInstanceOf(InvalidRegisterCarsInputLengthException.class)
            );
        }

        @Test
        void 자동차_이름_중복_테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("oo,oo", "1"))
                            .isInstanceOf(DuplicateCarNameException.class)
            );
        }

        @Test
        void 자동차_이름_길이_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                            .isInstanceOf(InvalidCarNameLengthException.class)
            );
        }

        @Test
        void 특수문자_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("-pobi,java", "1"))
                            .isInstanceOf(InvalidCharacterException.class)
            );
        }

        @Test
        void 빈_입력값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("", "1"))
                            .isInstanceOf(EmptyInputException.class)
            );
        }
    }

    @Nested
    @DisplayName("시도횟수 등록중 예외테스트")
    class ExecutionNumberRegistExceptionTests {

        @Test
        void 빈_입력값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "\n"))
                            .isInstanceOf(EmptyInputException.class)
            );
        }

        @Test
        @DisplayName("0 범위 예외 테스트")
        void 범위_예외테스트1() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "0"))
                            .isInstanceOf(NumberRangeException.class)
            );
        }

        @Test
        @DisplayName("최대 범위 예외 테스트")
        void 범위_예외테스트2() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("abc", "1001"))
                            .isInstanceOf(NumberRangeException.class)
            );
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
