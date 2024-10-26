package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"p", "po", "pob", "pobi", "pobii"})
    void 자동차_이름은_5글자이내(String name) {
        Car car = new Car(name);

        assertThat(car.getName().length()).isLessThanOrEqualTo(5);
    }
}
