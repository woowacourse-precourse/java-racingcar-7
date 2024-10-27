package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.domain.Cars;
import racingcar.model.domain.RoundResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RoundResultTest {

    @Test
    void 라운드_기록을_반환하다() {
        Cars cars = Cars.from(List.of("pobi", "woni"), new TestNumberGenerator(List.of(3, 4)));
        Cars movedCars = cars.moveForward();
        String expected = "pobi : \n" + "woni : -\n";

        RoundResult roundResult = RoundResult.from(movedCars);

        assertEquals(expected, roundResult.toString());
    }
}
