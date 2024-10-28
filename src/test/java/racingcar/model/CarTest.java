package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @DisplayName("Car 객체를 생성할 수 있다.")
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void canCreateCar(String name) {
        // when
        Car car = new Car(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 비어있으면 예외를 발생시킨다.")
    @ValueSource(strings = {"", " "})
    void throwExceptionWhenCarNameIsEmpty(String emptyName) {
        // when & then
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 최대 길이를 초과하면 예외를 발생시킨다.")
    @ValueSource(strings = {"woowac", "longname"})
    void throwExceptionWhenCarNameExceedsMaxLength(String longName) {
        // when & then
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("이동 가능할 경우 자동차가 이동한다.")
    @CsvSource({"pobi, true, 1", "woni, true, 1"})
    void moveCarWhenPossible(String name, boolean canMove, int expectedDistance) {
        // given
        Car car = new Car(name);

        // when
        car.moveIfPossible(canMove);

        // then
        assertThat(car.getMoveDistance()).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @DisplayName("이동 불가능할 경우 자동차가 이동하지 않는다.")
    @CsvSource({"pobi, false, 0", "woni, false, 0"})
    void doNotMoveCarWhenNotPossible(String name, boolean canMove, int expectedDistance) {
        // given
        Car car = new Car(name);

        // when
        car.moveIfPossible(canMove);

        // then
        assertThat(car.getMoveDistance()).isEqualTo(expectedDistance);
    }
}
