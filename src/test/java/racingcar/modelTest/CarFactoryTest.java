package racingcar.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarFactory;

class CarFactoryTest {

    @Test
    void 자동차_이름_정상_저장_테스트() {
        // given
        String carName = "TestCar";

        // when
        Car car = CarFactory.createCar(carName);

        // then
        assertNotNull(car, "Car 객체가 null이 아닙니다.");
        assertEquals(carName, car.getName(), "CarFactory에서 생성된 자동차 이름이 올바르지 않습니다.");
        assertEquals(0, car.getPosition(), "CarFactory에서 생성된 자동차의 초기 위치는 0이어야 합니다.");

        // 출력
        System.out.println("생성된 자동차 이름: " + car.getName());
    }

    @Test
    void 자동차_목록_정상_생성_테스트() {
        // given
        List<String> carNames = List.of("Car1", "Car2", "Car3");

        // when
        List<Car> cars = CarFactory.createCarList(carNames);

        // then
        assertNotNull(cars, "Car 목록이 null이 아닙니다.");
        assertEquals(carNames.size(), cars.size(), "자동차 목록 크기가 예상과 일치하지 않습니다.");

        // 각 자동차의 이름과 초기 위치 확인 및 출력
        for (int i = 0; i < carNames.size(); i++) {
            Car car = cars.get(i);
            assertEquals(carNames.get(i), car.getName(), "CarFactory에서 생성된 자동차 이름이 올바르지 않습니다.");
            assertEquals(0, car.getPosition(), "CarFactory에서 생성된 자동차의 초기 위치는 0이어야 합니다.");

            // 출력
            System.out.println("생성된 자동차 이름: " + car.getName());
        }
    }
}