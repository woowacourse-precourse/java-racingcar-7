package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("더 많이 전진했다면 True를 반환한다.")
    void isMaxForwardNumber_True() {
        Car car = Car.of("pobi", 3);

        boolean result = car.isMaxForwardNumber(2);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("더 많이 전진하지 못했다면 False를 반환한다.")
    void isMaxForwardNumber_False() {
        Car car = Car.of("pobi", 3);

        boolean result = car.isMaxForwardNumber(4);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("전진 횟수를 반환한다.")
    void getForwardNumber() {
        Car car = Car.of("pobi", 3);

        int result = car.getForwardNumber();

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("전진을 가장 많이했다면 True를 반환한다.")
    void isWinner_True() {
        Car car = Car.of("pobi", 3);
        int maxForwardNumber = 3;

        boolean result = car.isWinner(maxForwardNumber);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("전진을 가장 많이하지 않았으면 False를 반환한다.")
    void isWinner_False() {
        Car car = Car.of("pobi", 3);
        int maxForwardNumber = 4;

        boolean result = car.isWinner(maxForwardNumber);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("이름을 반환한다.")
    void getName() {
        Car car = Car.of("pobi", 3);

        String result = car.getName();

        assertThat(result).isEqualTo("pobi");
    }

    @Test
    @DisplayName("전진 수 만큼 -로 변환하여 이름과 함께 반환한다.")
    void testToString() {
        Car car = Car.of("pobi", 3);

        String result = car.toString();

        assertThat(result).isEqualTo("pobi : ---");
    }

}