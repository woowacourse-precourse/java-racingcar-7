package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Jiwoo", "--");
    }

    @Test
    void 랜덤수가_3인_경우_움직이지_않는다() {
        assertThat(car.act(3).getState()).isEqualTo("--");
    }

    @Test
    void 랜덤수가_4인_경우_움직인다() {
        assertThat(car.act(4).getState()).isEqualTo("---");
    }

    @Test
    void n번_움직일_경우_상태가_정상_저장된다(){
        for (int i=0;i<2;i++){
            car.act(4);
        }

        assertThat(car.getState()).isEqualTo("----");
    }
}