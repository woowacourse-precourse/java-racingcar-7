package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"precourse"})
    void 자동차_생성에_실패한다(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni"})
    void 자동차_생성에_성공한다(String name) {
        Car car = new Car(name);
        assertThat(car).isNotNull()
                .isEqualTo(new Car(name));
    }
}
