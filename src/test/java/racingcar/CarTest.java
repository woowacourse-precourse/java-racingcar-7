package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Car.createCar;

class CarTest {

    @DisplayName("차 이름이 5 이하이면 차가 정상적으로 생성된다.")
    @Test
    void createCarWithValidNameLength() {

        Car car = createCar("apple");

        assertThat(car.getCarName()).isEqualTo("apple");
        assertThat(car.getScore()).isZero();
    }

    @DisplayName("차 이름이 5 이하이면, 특수문자가 포함되어도 차가 정상적으로 생성된다.")
    @Test
    void createCarWithSpecialStrings() {

        Car car = createCar("a#p*e");

        assertThat(car.getCarName()).isEqualTo("a#p*e");
        assertThat(car.getScore()).isZero();
    }

    @DisplayName("차 이름이 5가 넘으면 예외를 발생한다.")
    @Test
    void createCarWithInvalidNameLength() {

        assertThatThrownBy(() -> createCar("banana"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("4 이상의 숫자에 대해서는 점수를 1 증가시킨다.")
    @Test
    void proceedByValidNumber() {

        Car car = createCar("apple");
        int randomNumber = 4;
        int proceedNumber = car.proceed(randomNumber);

        assertThat(proceedNumber).isEqualTo(1);
    }

    @DisplayName("4 미만의 숫자에 대해서는 점수를 증가시키지 않는다.")
    @Test
    void proceedByInvalidNumber() {

        Car car = createCar("apple");
        int randomNumber = 3;
        int proceedNumber = car.proceed(randomNumber);

        assertThat(proceedNumber).isEqualTo(0);
    }


}