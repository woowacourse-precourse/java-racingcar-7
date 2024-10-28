package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class CarTest {

    @Test
    @DisplayName("이동할 수 있는 경우, 전진한다.")
    void move_whenStrategyAllows() {
        //항상 canMove가 true인 전략
        Car car = new Car("Car", () -> true);

        car.oneRoundStart();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동할 수 없는 경우, 전진한다.")
    void notMove_whenStrategy() {
        //항상 canMove가 false인 전략
        Car car = new Car("Car", () -> false);  // 전진 불가

        car.oneRoundStart();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("car1이 car3보다 앞에 있는 경우 isAheadOf가 true를 반환해야 한다.")
    @Test
    void isAheadOf_true() {
        Car car1 = new Car("Car1", () -> true);
        Car car3 = new Car("Car3", () -> false);

        car1.oneRoundStart();

        assertThat(car1.isAheadOf(car3)).isTrue();
    }

    @DisplayName("car3이 car1보다 뒤에 있는 경우 isAheadOf가 false를 반환해야 한다.")
    @Test
    void isAheadOf_false() {
        Car car1 = new Car("Car1", () -> true);
        Car car3 = new Car("Car3", () -> false);

        car1.oneRoundStart();

        assertThat(car3.isAheadOf(car1)).isFalse();
    }

    @DisplayName("car1과 car2의 위치가 동일한 경우 isSamePositionAs가 true를 반환해야 한다.")
    @Test
    void isSamePositionAs_Equal() {
        Car car1 = new Car("Car1", () -> true);
        Car car2 = new Car("Car2", () -> true);

        car1.oneRoundStart();
        car2.oneRoundStart();

        assertThat(car1.isSamePositionAs(car2)).isTrue();
    }

    @DisplayName("car1과 car3의 위치가 다른 경우 isSamePositionAs가 false를 반환해야 한다.")
    @Test
    void isSamePositionAs_Differ() {
        Car car1 = new Car("Car1", () -> true);
        Car car3 = new Car("Car3", () -> false);

        car1.oneRoundStart();

        assertThat(car1.isSamePositionAs(car3)).isFalse();
    }


    @DisplayName("이름이 5자인 경우 정상적으로 생성된다.")
    @Test
    void validNameLength() {
        //given
        String validName = "가나다라마";

        //when
        Car car = new Car(validName, () -> true);

        // then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(validName);
    }


    @DisplayName("이름이 5자 초과하는 경우 에러가 발생한다.")
    @Test
    void errorExceedsLength() {
        // given
        String errorName = "가나다라마바";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(errorName, () -> true),
                "이름이 5글자 초과하면 에러가 발생해야 합니다.");
    }

    @DisplayName("이름이 빈 문자열인 경우 에러를 발생시킨다.")
    @Test
    void errorEmptyName() {
        // given
        String errorName = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(errorName, () -> true), "이름이 빈문자열이면 에러가 발생해야 합니다.");
    }

    @DisplayName("이름이 null인 경우 에러가 발생한다.")
    @Test
    void errorNullName() {
        // given
        String errorName = null;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new Car(errorName, () -> true), "이름이 null이면 에러가 발생해야 합니다.");
    }

}