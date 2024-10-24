package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    Car car;
    String carName = "test";

    @BeforeEach
    void setUp() {
        car = new Car(carName);
    }

    @Test
    @DisplayName("4를 기준으로 전진 혹은 정지 테스트")
    void move_테스트() {
        // given
        int numberLessThanFour = 2;
        int numberOverThanFour = 8;

        // when & then
        assertThat(car.move(numberLessThanFour)).isFalse();
        assertThat(car.move(numberOverThanFour)).isTrue();
    }

    @Test
    @DisplayName("getName 호출로 차이름 조회 테스트")
    void getName_차이름_조회테스트() {
        // when & then
        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    @DisplayName("int_인스턴스변수는_객체생성시_값이없다면_0으로_할당된다")
    void getMoveCount_초기값_테스트() {
        // when & then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("1번 움직인 후 moveCount 조회")
    void getMoveCount_실제_움직임_반영_테스트() {
        // given
        int numberOverThanFour = 8;

        // when & then
        assertThat(car.move(numberOverThanFour)).isTrue();
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}