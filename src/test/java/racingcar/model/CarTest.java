package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarTest {

    @Test
    void 이름_길이가_5이상이면_예외를_반환한다() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름에_공백이나_null이_들어오면_예외를_반환한다(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}