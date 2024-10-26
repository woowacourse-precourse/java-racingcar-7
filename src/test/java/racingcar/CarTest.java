package racingcar;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.UserInputData;

class CarTest {
    @Test
    @DisplayName("자동차가 전진했을때 위치가 1씩 증가하는지 테스트")
    void randomlyMove() {
        //given
        Car car1 = new Car("pobi");
        Car car2 = new Car("jun");

        //when
        car1.moveRandomly(true);
        car1.moveRandomly(true);
        car2.moveRandomly(false);
        int car1Position= car1.getPosition();
        int car2Position= car2.getPosition();

        //then
        Assertions.assertThat(car1Position).isEqualTo(2);
        Assertions.assertThat(car2Position).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("wrongNameProvider")
    @DisplayName("자동차 이름 입력시 잘못된 이름이 있는 경우 예외처리 테스트")
    void createCarsByNames(List<String> splitNames) {
        Assertions.assertThatThrownBy(() -> Car.createCarsByNames(splitNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> wrongNameProvider() {
        return Stream.of(
                Arguments.of(List.of("pobi","over5wordNames")),
                Arguments.of(List.of("pobi","abc@#$")),
                Arguments.of(List.of("pobi","sb  gk")),
                Arguments.of(List.of("pobi","    ")),
                Arguments.of(List.of("pobi",""))     );
    };
}
