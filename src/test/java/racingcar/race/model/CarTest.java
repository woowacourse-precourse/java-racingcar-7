package racingcar.race.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"dodo", "whale", "zico"})
    void 이름이_5자이하이면_CAR_객체가_생성된다(String name) {
        // given
        // when
        Car car = new Car(name);
        // then
        assertThat(car).isNotNull();

    }

    @ParameterizedTest
    @ValueSource(strings = {"docker", "elegant", "whyWhale"})
    void 이름이_6자이상이면_CAR_객체_생성시_예외가_발생한다(String name) {
        // given

        // when
        // then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}