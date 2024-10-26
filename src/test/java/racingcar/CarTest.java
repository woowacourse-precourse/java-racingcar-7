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

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 무작위값이_4이상인_경우_전진(int randomValue) {
        Car car = new Car("pobi");
        car.attemptMove(randomValue);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 무작위값이_3이하인_경우_정지(int randomValue) {
        Car car = new Car("pobi");
        car.attemptMove(randomValue);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
