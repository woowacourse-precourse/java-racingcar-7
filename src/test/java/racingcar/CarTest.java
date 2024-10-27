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

    public static Car createTestCar(String carName) {
        return new Car(carName, new BrokenAccelerator());
    }

    @Test
    public void 자동차_이름_주행거리_초기화_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = createTestCar(carName);

        //When
        String actualName = car.getName();
        int actualMileage = car.getMileage();

        //Then
        Assertions.assertThat(actualName).isEqualTo(carName);
        Assertions.assertThat(actualMileage).isEqualTo(0);
    }

    @Test
    public void 자동차_정지_출력_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = createTestCar(carName);
        String expected = "pobi : ";

        //When
        String actual = car.getDrivingRecord();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 자동차_전진_출력_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = createTestCar(carName);
        assertRandomNumberInRangeTest(
                car::accelerate,
                MOVING_FORWARD
        );
        String expected = "pobi : -";

        //When
        String actual = car.getDrivingRecord();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}