package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


// 사용자가 값을 입력하지 않았을 경우에도 자동차를 생성할 수 있어야 한다.
public class CarTest {
    @Test
    void 입력_테스트() {
        Car car = new Car("해건");
        assertThat(car.getName()).isEqualTo("해건");
    }
//
//    @Test
//    void 랜덤값이_4_이상일_때() {
//        Car car = new Car("해건");
//        car.decideProgressByRandomNumber(3);
//        assertThat(car.getProgressCount()).isEqualTo(0);
//        car.decideProgressByRandomNumber(4);
//        assertThat(car.getProgressCount()).isEqualTo(1);
//    }



}
