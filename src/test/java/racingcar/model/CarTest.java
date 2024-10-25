package racingcar.model;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 자동차_이름_null(){
        assertThatThrownBy(()->new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 null이 될 수 없습니다.");
    }

    @Test
}