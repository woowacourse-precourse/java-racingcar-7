package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConvertorTest {

    @DisplayName("문자열로 구분된 자동차들을 리스트로 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'pobi,woni,jun', 3,",
            "'pobi', 1"
    })
    void splitCarNamesToList(String carNames, int expectedSize) {
        //given
        String[] splitCarNames = carNames.split(",");

        //when
        List<String> cars = Convertor.toList(splitCarNames);

        //then
        assertThat(cars).hasSize(expectedSize);
    }

    @DisplayName("문자열로 된 시도 횟수를 정수로 변환하여 반환한다.")
    @Test
    void toInt() {
        //given
        String tryCount = "1";

        //when
        int result = Convertor.toInt(tryCount);

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("공백이 포함되거나, 정수 이외의 값이 들어오면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1 3", " ", "1.2"})
    void nonNumericToInt(String tryCount) {
        //given //when //then
        assertThatThrownBy(() -> Convertor.toInt(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이상의 정수값이 들어오면 예외를 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "13", "12"})
    void numericToInt(String tryCount) {
        //given //when //then
        assertThatCode(() -> Convertor.toInt(tryCount))
                .doesNotThrowAnyException();
    }
}