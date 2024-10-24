package vehicle;

import common.RacingCarBeanFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import policy.RacingCarPolicy;

class CarTest {

    @DisplayName("자동차 이름은 5글자를 넘을 수 없다.")
    @Test
    void validateNameLength() {
        //given
        RacingCarBeanFactory beanFactory = new RacingCarBeanFactory();
        RacingCarPolicy racingCarPolicy = new RacingCarPolicy();
        //when
        //then
        Assertions.assertThatThrownBy(() ->
                new Car("dadadada",new RacingCarPolicy())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 "+racingCarPolicy.getNameLengthPolicy()+"를 넘을 수 없습니다.");
    }


}