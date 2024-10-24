package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" "})
    @DisplayName("입력 값이 비어있는 경우 예외가 발생한다.")
    void validateNonEmpty(String candidate) {
        assertThatThrownBy(() -> Input.from(candidate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

}