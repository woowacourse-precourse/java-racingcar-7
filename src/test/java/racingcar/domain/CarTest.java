package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"''", "'pobipo'"})
    void 비어있거나_5글자초과면_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"'po bi'", "pobi!"})
    void 알파벳이나_숫자가_아닌_문자가_들어오면_예외처리(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}