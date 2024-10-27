package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car testCar;

    @BeforeEach
    void setUp(){
        testCar = new Car("car1");
    }

    @Test
    void 랜덤_4_이상_테스트(){
        Assertions.assertRandomNumberInRangeTest(
                ()-> testCar.playCar(),
                4,5,6,7,8,9
        );

        assertThat(testCar.getInstance()).isEqualTo(1);
    }

    @Test
    void 랜덤_4_미만_테스트(){
        Assertions.assertRandomNumberInRangeTest(
                ()-> testCar.playCar(),
                0,1,2,3
        );

        assertThat(testCar.getInstance()).isEqualTo(0);
    }

}