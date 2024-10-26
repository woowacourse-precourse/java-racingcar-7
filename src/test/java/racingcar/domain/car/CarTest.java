package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 전진하기로_결정되면_전진한다() throws Exception {
        //given
        ForwardPolicy testPolicy = () -> true;
        Car car = new Car("A", testPolicy);

        //when
        car.tryForward();

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 전진하지_않기로_결정되면_전진하지_않는다() throws Exception {
        //given
        ForwardPolicy testPolicy = () -> false;
        Car car = new Car("A", testPolicy);

        //when
        car.tryForward();

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}