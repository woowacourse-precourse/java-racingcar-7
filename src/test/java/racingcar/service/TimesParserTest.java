package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TimesParserTest {

    @DisplayName("입력받은 문자열을 숫자로 파싱해 레이싱 횟수로 사용한다")
    @ParameterizedTest
    @CsvSource({
            "4, 4",
            " 2, 2",
            "5 , 5"
    })
    void 시행_횟수_파싱(String input, int expected) {
        int times = TimesParser.parseTimes(input);
        Assertions.assertThat(times).isEqualTo(expected);
    }

}
