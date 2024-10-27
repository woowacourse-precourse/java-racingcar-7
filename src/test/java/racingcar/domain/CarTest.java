package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        car.judgeMove(randomNumber);
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 안_움직이는지_테스트() {
        //given
        int randomNumber = 1;
        //when
        car.judgeMove(randomNumber);
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
