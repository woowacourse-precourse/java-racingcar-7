package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이름_길이가_5이상이면_예외를_반환한다() {
        assertThatThrownBy(() -> new Car("exceed"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름에_공백이나_null이_들어오면_예외를_반환한다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}