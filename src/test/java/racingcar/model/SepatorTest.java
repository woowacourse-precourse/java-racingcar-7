package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.constant.Message;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class SepatorTest {

    @Test
    public void 분리기_정상_테스트() throws Exception {
        //given
        String input = "pobi,woni, jun";

        //when
        Sepator sepator = new Sepator();
        List<Car> cars = sepator.separateCars(input);

        //then
        assertEquals(cars.size(), 3);
        assertEquals(cars.get(0).getName(), "pobi");
        assertEquals(cars.get(1).getName(), "woni");
        assertEquals(cars.get(2).getName(), " jun");
    }

    @Test
    public void 자동차_이름이_없는_경우_테스트() throws Exception {
        //given
        String input1 = "pobi,";
        String input2 = ",woni";
        String input3 = "pobi,,jun";
        String input4 = "";


        //when
        Sepator sepator = new Sepator();

        //then
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input1), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input2), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input3), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input4), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());

    }

}