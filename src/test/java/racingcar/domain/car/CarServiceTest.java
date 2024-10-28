package racingcar.domain.car;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomUtil;
import racingcar.util.RandomUtilTest;

class CarServiceTest {

    @Test
    @DisplayName("String의 List를 넣을 시 Car List 반환")
    void getCars() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarService carService = new CarService(new RandomUtil());

        // when
        List<Car> cars = carService.getCars(carNames);

        // then
        Assertions.assertEquals(carNames.size(), cars.size());

        for (int i = 0; i < carNames.size(); i++) {
            Assertions.assertEquals(carNames.get(i), cars.get(i).getName());
        }
    }

    @Test
    @DisplayName("랜덤 수가 4가 넘을 경우 moveCount + 1")
    void incrementMoveCountSuccess() {
        // given
        Car car = new Car("pobi");
        CarService carService = new CarService(
                new RandomUtilTest(RandomUtilTest.SUCCESS_CONDITION));

        // when
        carService.incrementMoveCount(car);

        // then
        Assertions.assertEquals(car.getMoveCount(), 1);
    }

    @Test
    @DisplayName("랜덤 수가 4가 넘지 않을 경우 pass")
    void incrementMoveCountFail() {
        // given
        Car car = new Car("pobi");
        CarService carService = new CarService(new RandomUtilTest(RandomUtilTest.FAIL_CONDITION));

        // when
        carService.incrementMoveCount(car);

        // then
        Assertions.assertEquals(car.getMoveCount(), 0);
    }
}