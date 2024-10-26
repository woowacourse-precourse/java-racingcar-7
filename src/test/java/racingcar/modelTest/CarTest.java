package racingcar.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class CarTest {

    @Test
    void 자동차_이름_정상_저장_테스트() {
        // given
        String carName = "TestCar";

        // when
        Car car = new Car(carName);

        // then
        assertEquals(carName, car.getName(), "자동차 이름이 올바르게 저장되지 않았습니다.");
    }

    @Test
    void 자동차_초기_위치_확인_테스트() {
        // given
        String carName = "TestCar";

        // when
        Car car = new Car(carName);

        // then
        assertEquals(0, car.getPosition(), "자동차의 초기 위치는 0이어야 합니다.");
    }

    @Test
    void 자동차_이동_기능_테스트() {
        // given
        String carName = "TestCar";
        Car car = new Car(carName);

        // when
        car.move();

        // then
        assertEquals(1, car.getPosition(), "자동차가 한 칸 앞으로 이동해야 합니다.");
    }

    @Test
    void 자동차_여러번_이동_기능_테스트() {
        // given
        String carName = "TestCar";
        Car car = new Car(carName);

        // when
        car.move();
        car.move();
        car.move();

        // then
        assertEquals(3, car.getPosition(), "자동차가 3번 이동한 후 위치가 3이어야 합니다.");
    }
}