package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    @DisplayName("시작 위치 자동차 생성 테스트")
    @Test
    void createCar() {
        Car car = Car.createCarAtStartLine("fobi");
        assertEquals(car.getCarName(), "fobi");
        assertEquals(car.getCarDistance(), 0);
    }

    @DisplayName("자동차 이름 예외발생 테스트")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("wrongNames")
    void validateName(String name) {
        assertThrows(IllegalArgumentException.class, () -> Car.createCarAtStartLine(name));
    }

    static Stream<Arguments> wrongNames() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("car!"),
                Arguments.of("longNameCar")
        );
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void moveCar() {
        Car car = Car.createCarAtStartLine("fobi");
        for (int i = 0; i < 3; i++) {
            car.moveForward();
        }
        assertEquals(car.getCarDistance(), 3);
    }
}