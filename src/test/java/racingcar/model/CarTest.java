package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 생성자_테스트() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getScore()).isEqualTo(0);
    }

    @Test
    void 랜덤값_점수_증가_테스트_실패() {
        Car car = new Car("test");
        int initialScore = car.getScore();
        car.move(3);
        assertThat(car.getScore()).isEqualTo(initialScore);
    }

    @Test
    void 랜덤값_점수_증가_테스트_성공() {
        Car car = new Car("test");
        int initialScore = car.getScore();
        car.move(4);
        assertThat(car.getScore()).isEqualTo(initialScore + 1);
    }
}
