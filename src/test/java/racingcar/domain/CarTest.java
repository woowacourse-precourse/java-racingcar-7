package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void validateTest_whenNameIsEmpty_throwsException(String emptyName) {
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1글자 이상 5글자 이하이어야 합니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "abcdef"})
    void validateTest_whenNameLengthIsOverBound_throwsException(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1글자 이상 5글자 이하이어야 합니다");
    }
}
