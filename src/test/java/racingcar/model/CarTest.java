package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;


    @BeforeEach
    public void setUp() {
        this.car = new Car();
    }

    @Test
    @DisplayName("자동차 이동 기능 테스트")
    public void moveTest(){
        // given
        int moveCount = 3;
        // when
        car.move();
        car.move();
        car.move();
        // then
        assertThat(car.getDistance()).isEqualTo(moveCount);
    }
}
