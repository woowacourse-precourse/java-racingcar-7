package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameFormatException;
import racingcar.exception.CountFormatException;
import racingcar.exception.CountNegativeException;

class InputValidatorTest {

    @Test
    public void 자동차_이름_공백_예외_테스트() {
        List<String> carNames = List.of(" ");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_NULL_예외_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add(null);

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_5글자_초과_예외_테스트() {
        List<String> carNames = List.of("seanii");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_중복_예외_테스트() {
        List<String> carNames = List.of("sean", "car3", "sean");

        assertThatThrownBy(() -> InputValidator.validateCarNames(carNames))
                .isInstanceOf(CarNameDuplicatedException.class);
    }

    @Test
    public void 시도_횟수_음수_예외_테스트() {
        String countInput = "-1";

        assertThatThrownBy(() -> InputValidator.validateCount(countInput))
                .isInstanceOf(CountNegativeException.class);
    }

    @Test
    public void 시도_횟수_공백_예외_테스트() {
        String countInput = "";

        assertThatThrownBy(() -> InputValidator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_문자열_예외_테스트() {
        String countInput = "5번";

        assertThatThrownBy(() -> InputValidator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_NULL_예외_테스트() {
        String countInput = null;

        assertThatThrownBy(() -> InputValidator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_범위_초과_예외_테스트() {
        BigInteger bigInteger = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.valueOf(1));

        assertThatThrownBy(() -> InputValidator.validateCount(String.valueOf(bigInteger)))
                .isInstanceOf(CountFormatException.class);
    }
}