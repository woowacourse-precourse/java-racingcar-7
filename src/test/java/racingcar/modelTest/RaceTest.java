package racingcar.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

class RaceTest {

    @Test
    void 레이스_정상_동작_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );
        Race race = new Race();

        // when
        List<Car> resultCars = race.play(cars);

        // then
        assertNotNull(resultCars, "레이스 후의 자동차 목록이 null이어서는 안 됩니다.");
        assertEquals(cars.size(), resultCars.size(), "레이스 후의 자동차 수가 초기 자동차 수와 같아야 합니다.");
    }

    @Test
    void 레이스_자동차_움직임_출력_테스트() {
        // given
        List<Car> cars = Arrays.asList(
            new Car("Car1"),
            new Car("Car2"),
            new Car("Car3")
        );
        Race race = new Race();
        int tryCount = 100;
        List<Car> resultCars = new ArrayList<>();
        // when
        for (int i = 0; i < tryCount; i++) {
            resultCars = race.play(cars);
        }

        // then
        // 각 자동차의 움직임 출력
        for (Car car : resultCars) {
            System.out.println(car.getName() + "의 위치: " + car.getPosition());
        }

        // 적어도 한 대의 자동차는 움직였는지 확인
        boolean anyCarMoved = resultCars.stream().anyMatch(car -> car.getPosition() > 0);
        assertTrue(anyCarMoved, "레이스에서 적어도 한 대의 자동차는 움직여야 합니다.");
    }
}