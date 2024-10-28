package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameFormatException;
import racingcar.exception.CountFormatException;
import racingcar.exception.CountNegativeException;

class ValidatorTest {

    @Test
    public void 자동차_이름_공백_예외_테스트() {
        List<String> carNames = List.of(" ");

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_NULL_예외_테스트() {
        List<String> carNames = new ArrayList<>();
        carNames.add(null);

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_5글자_초과_예외_테스트() {
        List<String> carNames = List.of("seanii");

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_중복_예외_테스트() {
        List<String> carNames = List.of("sean", "car3", "sean");

        assertThatThrownBy(() -> Validator.validateCarNames(carNames))
                .isInstanceOf(CarNameDuplicatedException.class);
    }

    @Test
    public void 시도_횟수_음수_예외_테스트() {
        String countInput = "-1";

        assertThatThrownBy(() -> Validator.validateCount(countInput))
                .isInstanceOf(CountNegativeException.class);
    }

    @Test
    public void 시도_횟수_공백_예외_테스트() {
        String countInput = "";

        assertThatThrownBy(() -> Validator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_문자열_예외_테스트() {
        String countInput = "5번";

        assertThatThrownBy(() -> Validator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_NULL_예외_테스트() {
        String countInput = null;

        assertThatThrownBy(() -> Validator.validateCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_범위_초과_예외_테스트() {
        BigInteger bigInteger = BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.valueOf(1));

        assertThatThrownBy(() -> Validator.validateCount(String.valueOf(bigInteger)))
                .isInstanceOf(CountFormatException.class);
    }
}