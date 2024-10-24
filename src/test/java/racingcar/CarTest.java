package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.Accelerator;
import racingcar.accelerator.BrokenAccelerator;

class CarTest {

    private final Accelerator accelerator = new BrokenAccelerator();

    @Test
    public void 자동차_이름_주행거리_초기화_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = new Car(carName);

        //When
        String actualName = car.getName();
        int actualMileage = car.getMileage();

        //Then
        Assertions.assertThat(actualName).isEqualTo(carName);
        Assertions.assertThat(actualMileage).isEqualTo(0);
    }

    @Test
    public void 자동차이름_5글자이하_테스트() throws Exception {
        //Given
        String carName = "pobi";

        //When, Then
        Assertions.assertThatCode(() -> Car.validateName(carName))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차이름_5글자초과_예외테스트() throws Exception {
        //Given
        String carName = "woni:jun";

        //When, Then
        Assertions.assertThatCode(() -> Car.validateName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 빈_자동차이름_예외테스트() throws Exception {
        //Given
        String carName = "";

        //When, Then
        Assertions.assertThatCode(() -> Car.validateName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void toString_테스트() throws Exception {
        //Given
        Car car1 = new Car("pobi");
        String expected1 = "pobi : ";

        Car car2 = new Car("pobi");
        car2.setMileageForTest(3);
        String expected2 = "pobi : ---";

        //When
        String actual1 = car1.toString();
        String actual2 = car2.toString();

        //Then
        Assertions.assertThat(actual1).isEqualTo(expected1);
        Assertions.assertThat(actual2).isEqualTo(expected2);
    }
}