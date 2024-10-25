package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("이름이 5글자 이상일 때 예외가 발생해야 한다")
    void nameTooLong() {
        String longName = "abcdef";

        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 공백일 때 예외가 발생해야 한다")
    void nameIsEmpty() {
        String emptyName = "  ";

        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("이름에 공백이 포함될 때 예외가 발생해야 한다")
    @ValueSource(strings = {"poby ", "p oby", " poby"})
    void nameHasEmpty(String emptyName) {
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 영문자가 아닌 문자가 포함될 때 예외가 발생해야 한다")
    void nameContainsNonLetters() {
        String invalidName = "abc1";

        assertThatThrownBy(() -> new Car(invalidName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
