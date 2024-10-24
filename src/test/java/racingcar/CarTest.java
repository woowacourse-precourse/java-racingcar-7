package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Car 테스트")
public class CarTest {

    @Test
    void 자동차는_이름을_가진다() {
        //given
        Car car = new Car("pobi");

        //when
        String name = car.getName();

        //then
        assertThat(name).isEqualTo("pobi");
    }

    @Test
    void 자동차는_한_칸_앞으로_전진할_수_있다() {
        //given
        Car car = new Car("pobi");

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
