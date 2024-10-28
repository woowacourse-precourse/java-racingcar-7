package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountConverterTest {

    @DisplayName("시도 횟수 형변환을 확인한다.")
    @Test
    void 횟수_변환_성공() {
        TryCountConverter converter = new TryCountConverter("25");
        assertThat(converter.stringToInt()).isEqualTo(25);
    }

    @DisplayName("시도 횟수가 빈 문자열인지 확인한다.")
    @Test
    void 빈_문자열_입력_실패() {
        assertThatThrownBy(() -> new TryCountConverter(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 null인지 확인한다.")
    @Test
    void null_입력_실패() {
        assertThatThrownBy(() -> new TryCountConverter(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 시도 횟수가 정상적인 정수 형태인지 확인한다.")
    @Test
    void 입력_형식_실패() {
        assertThatThrownBy(() -> new TryCountConverter("abs"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 범위 이내 값인지 확인한다.")
    @Test
    void 입력_범위_실패() {
        assertThatThrownBy(() -> {
            TryCountConverter converter = new TryCountConverter("31");
            converter.stringToInt();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-1.0", "2.0"})
    void 범위_외_숫자_실패(String input) {
        assertThatThrownBy(() -> new TryCountConverter(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
