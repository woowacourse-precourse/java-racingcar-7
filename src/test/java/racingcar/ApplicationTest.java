package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.message.ErrorMessage;

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
    void 자동차_이름이_빈_문자열일_경우_예외_발생() {
        assertExceptionThrown("kim,,lee", "3", ErrorMessage.CAR_NAME_IS_EMPTY);
    }

    @Test
    void 자동차_이름이_공백_문자열일_경우_예외_발생() {
        assertExceptionThrown("kim, ,lee", "3", ErrorMessage.CAR_NAME_IS_SPACE);
    }

    @Test
    void 자동차_이름이_중복될_경우_예외_발생() {
        assertExceptionThrown("kim,kim", "3", ErrorMessage.CAR_NAME_IS_DUPLICATED);
    }

    @Test
    void 자동차_이름이_5자를_초과하는_경우_예외_발생() {
        assertExceptionThrown("kimyechan,lee", "3", ErrorMessage.CAR_NAME_IS_TOO_LONG);
    }

    @Test
    void 자동차_이름에_쉼표_외_특수문자_포함된_경우_예외_발생() {
        assertExceptionThrown("kim,Mr.k", "3", ErrorMessage.INVALID_NAME_CHARACTER);
    }

    @Test
    void 이동횟수가_음수인_경우_예외_발생() {
        assertExceptionThrown("pobi,woni", "-1", ErrorMessage.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 이동횟수가_숫자가_아닌_경우_예외_발생() {
        assertExceptionThrown("pobi,woni", "abc", ErrorMessage.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 자동차_이름에_숫자가_포함된_경우_예외_발생() {
        assertExceptionThrown("kim,1woni", "3", ErrorMessage.INVALID_NAME_CHARACTER);
    }

    private void assertExceptionThrown(String input, String rounds, ErrorMessage errorMessage) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input, rounds))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(errorMessage.getMessage())
        );
    }

    private void runException(String carNames, String rounds) {
        run(carNames, rounds);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
