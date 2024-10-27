package racingcar.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    void create() {
        String carNames = "pobi,woni";

        List<Car> cars = CarFactory.create(carNames);

        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni");
    }

    @ParameterizedTest
    @DisplayName("null, 빈 문자열, 공백 문자열, 5자 초과 입력시 예외발생 여부")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "pobi,woni,javaji"})
    void Exception(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> CarFactory.create(carNames));
    }
}