package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class ParserTest {

    @Test
    void parseCarList_success() {
        String cars = "pobi,woni,jun";

        List<Car> carList = Parser.parseCarList(cars);

        assertEquals(carList.get(0).getName(), "pobi");
        assertEquals(carList.get(1).getName(), "woni");
        assertEquals(carList.get(2).getName(), "jun");
    }

    @Test
    void parseCarList_name_length_exception() {
        String cars = "pobi,wonddi,jun";

        assertThatThrownBy(() -> Parser.parseCarList(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseCarList_empty_carList_exception() {
        String cars = "";

        assertThatThrownBy(() -> Parser.parseCarList(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseCarList_single_carList_exception() {
        String cars = "pobi";

        assertThatThrownBy(() -> Parser.parseCarList(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

}