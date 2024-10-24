package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차의 이름과 초기 위치가 올바르게 반환되는지 검증한다.")
    void 자동차_정보_출력_기능() {
        //given
        String carName = "min";
        Car car = new Car(carName);

        //when
        Map<String, Integer> carInfo = car.getCarInfo();

        //then
        assertTrue(carInfo.containsKey(carName));
        assertEquals(0, carInfo.get(carName));
    }

    @Test
    @DisplayName("자동차가 전진하면 위치가 1만큼 증가하는지 검증한다.")
    void 자동차_전진_기능() {
        // given
        String carName = "povi";
        Car car = new Car(carName);

        // when
        car.accelerator();

        // then
        assertEquals(1, car.getCarInfo().get(carName));
    }

    @Test
    @DisplayName("자동차가 다른 자동차보다 앞서 있는지 확인한다.")
    public void 자동차_위치_비교_기능() {
        //given
        Car car1 = new Car("povi");
        Car car2 = new Car("min");

        //when
        car1.accelerator();
        boolean result = car1.isAheadOf(car2.getCarInfo().get("min"));

        //then
        Assertions.assertTrue(result);
    }
}