package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class CarTest {

    private final Car testCar = new Car("testCar");

    @Test
    @DisplayName("자동차 이름이 5글자 이하인 경우 이름 리스트 반환")
    void 이름_수_제한_통과_테스트() {
        Car car = new Car("four,fivee");
        Assertions.assertThat(car.makeCarList("four,fivee"))
                .hasSize(2)
                .extracting(Car::getName)
                .contains("four", "fivee");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과인 경우 IllegalException 발생")
    void 이름_수_제한_초과_테스트() {
        Car car = new Car("yubin8773");
        Assertions.assertThatThrownBy(() -> {
            car.checkLength("yubin8773");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 전진하면 - 추가")
    void 전진_상태_일때_저장값_검증_테스트(){
        testCar.moveCar("go");
        Assertions.assertThat(testCar.getMoveStatus())
                .isEqualTo("-");
    }

}