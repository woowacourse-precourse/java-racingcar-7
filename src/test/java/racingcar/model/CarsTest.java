package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 쉼표를_기준으로_입력을_잘라_이름_개수만큼_자동차를_만든다() {
        Cars cars = getCars();
        assertEquals(3, cars.getCars().size());
    }

    @Test
    void 쉼표를_기준으로_자른_이름이_5글자_보다_클_경우() {
        String input = "daesun,woni,jun";
        assertThrows(IllegalArgumentException.class, () -> Car.getInstance(input));
    }

    private Cars getCars() {
        String input = "pobi,woni,jun";
        return Cars.getInstance(input);
    }

}