package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차의 위치는 0부터 시작한다")
    @Test
    void initCarTest() {
        //given
        Car car = new Car("yj");
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("0 ~ 3일때는 자동차를 안 움직인다.")
    @Test
    void move_Zero_To_Three_Test() {
        //given
        List<Integer> numbers = List.of(0, 1, 2, 3);
        Car car = new Car("yj");
        //when
        for (int number : numbers) {
            car.move(number);
        }
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("4 ~ 9일때는 자동차를 움직인다.")
    @Test
    void move_Four_To_Nine_Test() {
        //given
        List<Integer> numbers = List.of(4, 5, 6, 7, 8, 9);
        Car car = new Car("yj");
        //when
        for (int number : numbers) {
            car.move(number);
        }
        //then
        assertThat(car.getPosition()).isEqualTo(6);
    }


}