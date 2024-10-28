package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WinnersTest {

    @Test
    void 우승자가_단일인_경우_1명만_반환한다() {
        // given
        Cars cars = new Cars("pobi");
        Car furthestCar = cars.getFurthestCar();

        Winners winner = new Winners(cars, furthestCar);

        // when
        String winnerString = winner.toString();

        // then
        assertEquals("pobi", winnerString);
    }

    @Test
    void 우승자가_여러일_경우_다수를_반환한다() {
        // given
        Cars cars = new Cars("pobi,jun");
        Car furthestCar = cars.getFurthestCar();

        Winners winner = new Winners(cars, furthestCar);

        // when
        String winnerString = winner.toString();

        // then
        assertEquals("pobi, jun", winnerString);
    }
}