package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.validator.CarNameValidator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("bo");
    }

    @Test
    void 움직이는지_테스트() {
        //given
        int randomNumber = 4;
        //when
        car.move(randomNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 안_움직이는지_테스트() {
        //given
        int randomNumber = 1;
        //when
        car.move(randomNumber);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
