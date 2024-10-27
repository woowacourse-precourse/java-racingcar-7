package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("Car 객체 생성 확인")
    void Car_객체_생성_확인() {
        Car car = new Car("dohun", 3);

        assertThat(car.getName()).isEqualTo("dohun");
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진시 위치가 증가하는지 확인")
    void 전진시_위치가_증가하는지_확인() {
        Car car = new Car("dohun", 3);

        car.forward();

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("남은 시도 횟수가 없을때 전진시 예외 발생")
    void 남은_시도_횟수가_없을때_전진시_예외_발생() {
        Car car = new Car("dohun", 0);

        Assertions.assertThrows(IllegalArgumentException.class,
                car::forward,
                "시도 횟수가 끝난 자동차는 움직일 수 없습니다.");
    }

    @Test
    @DisplayName("남은 시도 횟수가 없을때 후진시 예외 발생")
    void 남은_시도_횟수가_없을때_후진시_예외_발생() {
        Car car = new Car("dohun", 0);

        Assertions.assertThrows(IllegalArgumentException.class,
                car::stop,
                "시도 횟수가 끝난 자동차는 움직일 수 없습니다.");
    }
}