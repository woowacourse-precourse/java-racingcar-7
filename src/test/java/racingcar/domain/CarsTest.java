package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 정상_입력은_Cars_객체를_생성한다() {
        // given
        String carName = "pobi, jun";

        // when
        Cars cars = new Cars(carName);

        // when & then
        assertNotNull(cars);
    }

    @Test
    void 중복_입력은_예외를_발생한다() {
        // given
        String carName = "pobi, jun, pobi";

        // when & then
        assertThrows(IllegalArgumentException.class,
                () -> new Cars(carName));
    }

    @Test
    void 우승자_단일인_경우_단일_Car_리스트를_반환한다() {
        // given
        String carName = "pobi";
        Cars cars = new Cars(carName);

        // when
        Car furthestCar = cars.getFurthestCar();
        List<Car> winners = cars.findWinners(furthestCar);

        // then
        Assertions.assertEquals(1, winners.size());
    }

    @Test
    void 우승자_여러일_경우_여러_Car_리스트를_반환한다() {
        // given
        String carName = "pobi, jun";
        Cars cars = new Cars(carName);

        // when
        Car furthestCar = cars.getFurthestCar();
        List<Car> winners = cars.findWinners(furthestCar);

        // then
        Assertions.assertEquals(2, winners.size());
    }
}