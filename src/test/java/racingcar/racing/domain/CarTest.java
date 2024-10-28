package racingcar.racing.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void movedDistance의_난수_생성_확인() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            //given
            Car car = new Car("car");

            //when
            int distance = car.movedDistance();

            //then
            assertThat(distance).isEqualTo(7);
        }, 7);
    }

    @Test
    void 난수가_4_이상이면_거리_증가_성공() {
        Assertions.assertRandomNumberInRangeTest(() -> {
            //given
            Car car1 = new Car("car1");
            Car car2 = new Car("car2");

            //when
            car1.updateTotalDistance(car1.movedDistance());
            car2.updateTotalDistance(car2.movedDistance());

            //then
            assertThat(car1.getTotalDistance()).isEqualTo(1);
            assertThat(car2.getTotalDistance()).isEqualTo(0);
        }, 4, 3);
    }

    @Test
    void compareTo_정렬_확인() {
        Assertions.assertSimpleTest(() -> {
            //given
            //when
            //then
        });
    }
}
