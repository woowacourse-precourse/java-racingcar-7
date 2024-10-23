package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}