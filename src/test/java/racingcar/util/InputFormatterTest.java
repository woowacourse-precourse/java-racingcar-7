package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameDuplicatedException;
import racingcar.exception.CarNameFormatException;
import racingcar.exception.CountFormatException;
import racingcar.exception.CountNegativeException;

class InputFormatterTest {

    @ParameterizedTest
    @ValueSource(strings = {"sean,cool,happy", "sean, cool  ,happy", "  sean, cool  ,   happy"})
    public void 자동차_이름_입력_구분_테스트(String carInput) {
        List<String> carNames = List.of("sean", "cool", "happy");

        assertThat(InputFormatter.getFormattedCarNames(carInput))
                .hasSameElementsAs(carNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    ", " ,  ", "sean, "})
    public void 자동차_이름_공백_입력_오류_테스트(String carInput) {
        assertThatThrownBy(() -> InputFormatter.getFormattedCarNames(carInput))
                .isInstanceOf(CarNameFormatException.class);
    }

    @Test
    public void 자동차_이름_중복_입력_테스트() {
        String carInput = "sean,sean";

        assertThatThrownBy(() -> InputFormatter.getFormattedCarNames(carInput))
                .isInstanceOf(CarNameDuplicatedException.class);
    }

    @Test
    public void 시도_횟수_입력_테스트() {
        String countInput = "5";

        assertThat(InputFormatter.getFormattedCount(countInput))
                .isEqualTo(5);
    }

    @Test
    public void 시도_횟수_문자열_입력_테스트() {
        String countInput = "3번";

        assertThatThrownBy(() -> InputFormatter.getFormattedCount(countInput))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_범위_초과_입력_테스트() {
        String countBigInput = String.valueOf(BigInteger.valueOf(Integer.MAX_VALUE).add(BigInteger.valueOf(1)));

        assertThatThrownBy(() -> InputFormatter.getFormattedCount(String.valueOf(countBigInput)))
                .isInstanceOf(CountFormatException.class);
    }

    @Test
    public void 시도_횟수_음수_입력_테스트() {
        String countNegativeInput = "-4";

        assertThatThrownBy(() -> InputFormatter.getFormattedCount(String.valueOf(countNegativeInput)))
                .isInstanceOf(CountNegativeException.class);
    }
}