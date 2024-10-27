package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class ParserTest {

    @Test
    void parseCarList_success() {
        String cars = "pobi,woni,jun";

        List<Car> carList = Parser.parseCarList(cars);

        assertEquals("pobi", carList.get(0).getName());
        assertEquals("woni", carList.get(1).getName());
        assertEquals("jun", carList.get(2).getName());
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

    @Test
    void parseNum_success() {
        String num = "1";

        int result = Parser.parseNum(num);

        assertEquals(1, result);
    }

    @Test
    void parseNum_negative() {
        String num = "-1";

        assertThatThrownBy(() -> Parser.parseNum(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseNum_zero() {
        String num = "0";

        assertThatThrownBy(() -> Parser.parseNum(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseNum_over_max_int() {
        String num = "21474836470";

        assertThatThrownBy(() -> Parser.parseNum(num))
                .isInstanceOf(IllegalArgumentException.class);
    }

}