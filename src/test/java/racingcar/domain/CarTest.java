package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 객체_생성_값_반환_테스트(){
        Car car = new Car("seuk");

        assertThat(car.getName()).isEqualTo("seuk");    // 이름 검사
        assertThat(car.getMoveCount()).isZero();    // 0인지 검사
    }

    @Test
    void 자동차_전진_테스트(){
        Car car = new Car("seuk");

        car.move(5);
        assertThat(car.getMoveCount()).isOne(); // 1인지 검사
    }

}
