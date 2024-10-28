package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.NumberType.START_LOCATION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("차 이름과 함께 정상적으로 Car 객체가 만들어진다.")
    public void makeCar() {
        //given
        String carName = "jae";
        //when
        Car car = Car.of(carName);
        //then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getLocation()).isEqualTo(START_LOCATION.getNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 랜덤 숫자가 나올 경우 위치는 그대로여야한다.")
    public void stopCar(int number) {
        // given
        Car car = createTestCar();
        // when & then
        assertRandomNumberInRangeTest(() -> {
            car.startRace();

            assertThat(car.getLocation()).isEqualTo(START_LOCATION.getNumber());

        }, number);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상의 랜덤 숫자가 나올 경우 위치는 한 칸 앞으로 가야한다.")
    public void goCar(int number) {
        // given
        Car car = createTestCar();
        // when & then
        assertRandomNumberInRangeTest(() -> {
            car.startRace();

            assertThat(car.getLocation()).isEqualTo(START_LOCATION.getNumber() + 1);

        }, number);
    }

    private Car createTestCar() {
        String carName = "test";
        return Car.of(carName);
    }

}