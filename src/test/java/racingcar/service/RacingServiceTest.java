package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingServiceTest {

    @DisplayName("랜덥값이 4이상일 시 전진에 성공합니다")
    @Test
    void 자동차_전진_성공(){
        // given
        int randomValue = 5;
        Car car = new Car("car");
        // when
        RacingService.moveCar(car,RacingService.isMove(randomValue));
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo("-");
    }

    @DisplayName("랜덤값이 4보다 작으면 전진에 실패합니다")
    @Test
    void 자동차_전진_실패(){
        //given
        int randomValue = 3;
        Car car = new Car("car");
        //when
        RacingService.moveCar(car,RacingService.isMove(randomValue));
        //then
        Assertions.assertThat(car.getPosition()).isEqualTo("");
    }

}