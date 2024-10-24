package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("이동할 수 있는 경우, 전진한다.")
    void moveWhenStrategyAllows() {
        //항상 canMove가 true인 전략
        Car car = new Car("Car", () -> true);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동할 수 없는 경우, 전진한다.")
    void NotMoveWhenStrategy() {
        //항상 canMove가 false인 전략
        Car car = new Car("Car", () -> false);  // 전진 불가

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이름이 5자인 경우 정상적으로 생성된다.")
    @Test
    void validNameLenght() {
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