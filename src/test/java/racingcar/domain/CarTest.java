package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("Car 객체 생성자 테스트")
public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"wonnni", "junnnn", "123456", "pobiii", ""})
    void Should_ThrowException_When_CarName_Length_Exceeds_Five(String carName) {
        assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(carName);
        });
    }
}
