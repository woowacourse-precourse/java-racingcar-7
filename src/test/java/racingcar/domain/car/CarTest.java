package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.global.ErrorMessage;

class CarTest {

    private Car car;
    private final String name = "name";
    private MovingStrategy defaultStrategy;

    @BeforeEach
    void setUp() {
        this.defaultStrategy = new RandomMovingStrategy();
        car = new Car("name", defaultStrategy);
    }

    @Test
    @DisplayName("자동차는 생성자로 이름을 가진다")
    void construct() {
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("이름이 공백이거나 null인 경우 IllegalArgumentException을 던진다")
    @MethodSource("provideInvalidNames")
    void throwsIfBlankNameIn(String invalidName) {
        assertThatThrownBy(() -> new Car(invalidName, defaultStrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_CAR_NAME.getMessage());
    }

    private static Stream<Arguments> provideInvalidNames() {
        return Stream.of(
                Arguments.of((String) null),  // null 입력
                Arguments.of(""),             // 빈 문자열
                Arguments.of("   ")           // 공백 문자열
        );
    }

    @ParameterizedTest
    @CsvSource({"true,1", "false,0"})
    @DisplayName("movingStrategy 에 따라서, 움직이거나 움직이지 않는다.")
    void move(boolean movable, int expectedPosition) {
        Car customStrategyCar = new Car(name, () -> movable);
        customStrategyCar.move();
        Assertions.assertThat(customStrategyCar.getPosition()).isEqualTo(expectedPosition);
    }
}
