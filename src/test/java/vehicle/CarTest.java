package vehicle;

import common.BeanFactory;
import common.RacingCarBeanFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @Test
    void validateNameLength() {
        //given
        BeanFactory beanFactory = new RacingCarBeanFactory();
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                new Car("dadadada", beanFactory.provideRacingPolicy())).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 "+"5"+"를 넘을 수 없습니다.");
    }


}