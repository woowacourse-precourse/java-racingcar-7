package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("객체 생성을 정상적으로 생성한다.")
    void create() {
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 전진할때 position이 1 증가한다.")
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 객체를 복사할때 값이 잘 복사된다.")
    void copy() {
        car.move();
        Car copiedCar = new Car(car);
        assertThat(copiedCar.getName()).isEqualTo("pobi");
        assertThat(copiedCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 position이 주어졌을 때 우승자이면 true를 반환한다.")
    void isWinner() {
        car.move();
        int winnerPosition = 1;
        assertThat(car.isWinner(winnerPosition)).isTrue();
    }

    @Test
    @DisplayName("우승자 position이 주어졌을 때 우승자가 아니면 false를 반환한다.")
    void isNotWinner() {
        int winnerPosition = 1;
        assertThat(car.isWinner(winnerPosition)).isFalse();
    }

}
