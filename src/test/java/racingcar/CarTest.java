package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    private final Car TESTER_CAR = new Car("TEST");

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
        Assertions.assertThatCode(() -> TESTER_CAR.validateName(carName))
                .doesNotThrowAnyException();
    }

    @Test
    public void 자동차이름_5글자초과_예외테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carName = "woni:jun";

        //When, Then
        Assertions.assertThatThrownBy(() -> TESTER_CAR.validateName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 빈_자동차이름_예외테스트() throws Exception {
        //Given
        CarRacing carRacing = new CarRacing();
        String carName = "";

        //When, Then
        Assertions.assertThatThrownBy(() -> TESTER_CAR.validateName(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_전진_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = new Car(carName);
        int threshold = 4;
        int expected = 1;

        //When
        car.forwardOrStop(threshold);

        //When, Then
        Assertions.assertThat(car.getMileage()).isEqualTo(expected);
    }

    @Test
    public void 자동차_정지_테스트() throws Exception {
        //Given
        String carName = "pobi";
        Car car = new Car(carName);
        int threshold = 3;
        int expected = 0;

        //When
        car.forwardOrStop(threshold);

        //When, Then
        Assertions.assertThat(car.getMileage()).isEqualTo(expected);
    }
}