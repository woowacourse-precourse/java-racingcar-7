package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    @DisplayName("전진에 성공하면 거리가 늘어난다")
    @Test
    void goAheadTest(){
        RacingCar car = new RacingCar("car1");
        for (int i=0; i<5; i++){
            //4이상이면 전진
            car.goAhead(4);
        }

        Assertions.assertThat(car.getDistance()).isEqualTo(5);
    }
}