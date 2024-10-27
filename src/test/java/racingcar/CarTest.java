package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.Accelerator;
import racingcar.accelerator.BrokenAccelerator;

class CarTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final Accelerator accelerator = new BrokenAccelerator();

    public static Car createCarWithBrokenAcceleratorForTest(String carName) {
        return new Car(carName, new BrokenAccelerator());
    }

    @Test
    public void 자동차_이름_주행거리_초기화_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = createCarWithBrokenAcceleratorForTest(carName);

        //When
        String actualName = car.getName();
        int actualMileage = car.getMileage();

        //Then
        Assertions.assertThat(actualName).isEqualTo(carName);
        Assertions.assertThat(actualMileage).isEqualTo(0);
    }

    @Test
    public void 자동차_주행정보_출력_테스트() throws Exception {
        //Given
        String carName = "pobi";

        Car car1 = createCarWithBrokenAcceleratorForTest(carName);
        String expected1 = "pobi : ";

        Car car2 = createCarWithBrokenAcceleratorForTest(carName);
        assertRandomNumberInRangeTest(
                car2::accelerate,
                MOVING_FORWARD
        );
        String expected2 = "pobi : -";

        //When
        String actual1 = car1.getDrivingRecord();
        String actual2 = car2.getDrivingRecord();

        //Then
        Assertions.assertThat(actual1).isEqualTo(expected1);
        Assertions.assertThat(actual2).isEqualTo(expected2);
    }
}