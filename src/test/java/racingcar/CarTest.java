package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("차가 처음 생성되면 위치는 0이어야 한다")
    void 차_초기_위치_테스트() {
        Assertions.assertThat(car.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("무작위 값이 4 이상인 경우 차의 위치가 증가해야 한다")
    void 값_증가_자동차_위치_전진_테스트() {
        car.carPosition = 0;
        car.carMove();
        Assertions.assertThat(car.getCarPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("무작위 값이 4 미만일 경우 차의 위치가 감소해야 한다")
    void 값_감소_자동차_후진_테스트() {
        car.carPosition = 1;
        car.carMove();
        Assertions.assertThat(car.getCarPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    @DisplayName("차의 위치를 '-'로 표시해야 한다")
    void 자동차_위치_출력_테스트() {
        car.carPosition = 3;
        String expectedDisplay = "---";
        String actualDisplay = car.displayPosition();
        Assertions.assertThat(actualDisplay).isEqualTo(expectedDisplay);
    }
}