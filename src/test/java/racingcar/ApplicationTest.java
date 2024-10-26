package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameValidationError;
import racingcar.exception.GeneralError;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 통합테스트_두번쨰_우승_1라운드() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "1");
            assertThat(output()).contains("pobi : ", "woni : -", "최종 우승자 : woni");
        }, STOP, MOVING_FORWARD);
    }

    @Test
    void 통합테스트_두번쨰_우승_2라운드() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "2");
            assertThat(output()).contains("pobi : ", "woni : -", "pobi : ", "woni : --", "최종 우승자 : woni");
        }, STOP, MOVING_FORWARD);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    void 예외_차이름_빈문자열() {
        // given
        String inputCarNames = "";
        String inputRoundCount = "5";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> run(inputCarNames, inputRoundCount));

        // then
        assertThat(exception.getMessage()).isEqualTo(GeneralError.EMPTY_INPUT.getMessage());
    }

    @Test
    void 예외_차_이름에_공백포함() {
        // given
        String inputCarNames = " a ,b,c";
        String inputRoundCount = "5";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> run(inputCarNames, inputRoundCount));

        // then
        assertThat(exception.getMessage()).isEqualTo(CarNameValidationError.NAME_CONTAINS_SPACE.getMessage());
    }

    @Test
    void 예외_차_이름이_공백() {
        // given
        String inputCarNames = "";
        String inputRoundCount = "5";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> run(inputCarNames, inputRoundCount));

        // then
        assertThat(exception.getMessage()).isEqualTo(GeneralError.EMPTY_INPUT.getMessage());
    }

    @Test
    void 예외_라운드_입력이_공백() {
        // given
        String inputCarNames = "a,b,c";
        String inputRoundCount = "";

        // when
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> run(inputCarNames, inputRoundCount));

        // then
        assertThat(exception.getMessage()).isEqualTo(GeneralError.EMPTY_INPUT.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
