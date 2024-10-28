package racingcar.racing.domain;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.Assertions;
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
    void totalDistance_증가_확인() {
        Assertions.assertSimpleTest(() -> {
            //given
            //when
            //then
        });
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
