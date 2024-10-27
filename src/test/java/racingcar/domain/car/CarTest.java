package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private static final int FORWARD = 4;
    private static final int STOP = 3;

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하일 때 객체가 정상적으로 생성된다")
    void createCarWithValidName() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상일 때 예외가 발생한다")
    void throwExceptionWhenCarNameIsTooLong() {
        assertThatThrownBy(() -> new Car("pobiMacquire"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car name has to be 5 or under 5.");
    }

    @Test
    @DisplayName("자동차가 이동 조건을 만족할 때 position이 증가한다")
    void moveCarWhenConditionIsMet() {
        // given
        Car car = new Car("pobi", () -> FORWARD);

        // when
        car.moveIfPossible();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동 조건을 만족하지 않을 때 position이 증가하지 않는다")
    void doNotMoveCarWhenConditionIsNotMet() {
        // given
        Car car = new Car("pobi", () -> STOP);

        // when
        car.moveIfPossible();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 상태를 문자열로 반환할 수 있다")
    void returnCarStatusAsString() {
        // given
        Car car = new Car("pobi", () -> FORWARD);

        // when
        car.moveIfPossible();

        // then
        assertThat(car.toString()).isEqualTo("pobi : -");
    }

    @Test
    @DisplayName("자동차의 이름이 동일한 경우 equals 메서드가 true를 반환한다")
    void carsWithSameNameAreEqual() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");

        // when & then
        assertThat(car1).isEqualTo(car2);
    }

    @Test
    @DisplayName("자동차의 이름이 다를 경우 equals 메서드가 false를 반환한다")
    void carsWithDifferentNamesAreNotEqual() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");

        // when & then
        assertThat(car1).isNotEqualTo(car2);
    }
}
