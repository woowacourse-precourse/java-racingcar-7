package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void carNameIsEmpty(){
        assertThatThrownBy(() -> Car.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carNameIsTooLong(){
        assertThatThrownBy(() -> Car.from("dohyeong"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
