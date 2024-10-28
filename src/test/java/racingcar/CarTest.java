package racingcar;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    private static final int MOVEMENT_CONDITION = 4;

    @Test
    void 자동차를_성공적으로_생성한다() {
        // given
        String name = "바티스타";

        // when
        Car car = new Car(name);

        // then
        Assertions.assertThat(car.getName()).isEqualTo("바티스타");
    }

    @DisplayName("잘못된 값을 전달하면 예외가 발생한다 ")
    @ParameterizedTest(name = "자동차 이름 : {0} \t 예외 메시지: {1}")
    @CsvSource({
            "'', 이름이 비어있습니다.",
            "'!!!', 이름은 문자나 숫자만 가능합니다.",
            "'MyNameIsAlex', 이름은 5자 이하여야 합니다."
    })
    void 자동차_생성_실패(String name, String expectedMessage) {
        // when & then
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @DisplayName("숫자가 4 이상이면 위치를 1 증가시킨다")
    @ParameterizedTest(name = "숫자 : {0}, 예상 위치 : {1}")
    @MethodSource("providevalue")
    void move(int values, int expectedPosition) {
        // given
        Car car = new Car("재석");

        // when
        car.move(values);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest(name = "이동 횟수: {0}, 예상 표시 문자: {1}")
    @CsvSource(value = {"2,--", "3,---", "4,----"})
    void 자동차의_상태를_가져올수_있다(int givenMovement, String expectedLines) {
        // given
        Car car = new Car("재석");

        // when
        moveCar(car, givenMovement);

        // then
        String expected = "재석 : " + expectedLines;
        Assertions.assertThat(car.getStatus()).isEqualTo(expected);
    }

    private static void moveCar(Car car, int repeat) {
        for (int i = 0; i < repeat; i++) {
            car.move(MOVEMENT_CONDITION);
        }
    }

    static Stream<Arguments> providevalue() {
        return Stream.of(
                Arguments.of(4, 1),
                Arguments.of(9, 1),
                Arguments.of(0, 0),
                Arguments.of(3, 0)
        );
    }
}