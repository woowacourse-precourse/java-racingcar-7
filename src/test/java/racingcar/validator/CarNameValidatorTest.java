package racingcar.validator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.view.ErrorMessage;

public class CarNameValidatorTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름에_쉼표_이외의_특수문자_사용() {
        assertRandomNumberInRangeTest(() -> validateCarNames("pobi, Mr.k", "1"), MOVING_FORWARD, STOP);
    }

    private void validateCarNames(String input, String expected) {
        run(input, expected);
        assertThat(output()).contains("pobi : -", "Mr.k : ", "최종 우승자 : pobi");
    }

    @Test
    void 자동차의_이름이_공백으로만_이루어진_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("kim, , ,lee", ErrorMessage.CAR_NAME_IS_SPACE));
    }

    @Test
    void 자동차의_이름이_빈_문자열일_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("kim,,lee", ErrorMessage.CAR_NAME_IS_EMPTY));
    }

    @Test
    void 자동차의_이름이_중복되는_경우_예외_발생() {
        assertSimpleTest(() -> assertIllegalArgumentException("kim, kim", ErrorMessage.CAR_NAME_IS_DUPLICATED));
    }

    @Test
    void 자동차의_이름이_6자_이상인_경우_예외_발생() {
        assertSimpleTest(
                () -> assertIllegalArgumentException("kimyechan, kimminsoo", ErrorMessage.CAR_NAME_IS_TOO_LONG));
    }

    private void assertIllegalArgumentException(String input, ErrorMessage errorMessage) {
        assertThatThrownBy(() -> runException(input, "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
