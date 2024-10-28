package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static final String CAR_NAME = "pobi";
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_이름_등록_테스트() {
        Cars cars = createCar(CAR_NAME);

        assertThat(cars.getCarsMap()).containsKey(CAR_NAME);
    }

    @Test
    void 자동차_1칸_전진_테스트() {
        Cars cars = createCar(CAR_NAME);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.run();
                    assertThat(cars.getCarsMap()).containsEntry(CAR_NAME, 1);
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지_테스트() {
        Cars cars = createCar(CAR_NAME);

        assertRandomNumberInRangeTest(
                () -> {
                    cars.run();
                    assertThat(cars.getCarsMap()).containsEntry(CAR_NAME, 0);
                },
                STOP
        );
    }


    private Cars createCar(String carName) {
        return new Cars(List.of(carName));
    }

}
