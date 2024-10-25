package racingcar.util.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountConverterTest {
    @Test
    @DisplayName("시도 횟수 문자열을 숫자형태로 잘 변환한다.")
    void convert() {
        String input = "3";
        assertThat(TryCountConverter.convert(input)).isEqualTo(3);
    }
}
