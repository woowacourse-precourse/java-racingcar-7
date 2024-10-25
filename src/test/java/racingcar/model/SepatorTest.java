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
        Separator sepator = new Separator();
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
        Separator sepator = new Separator();

        //then
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input1), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input2), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input3), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());
        assertThrows(IllegalArgumentException.class, () -> sepator.separateCars(input4), Message.CAR_NAME_EMPTY_VALIDATION_MESSAGE.getMessage());

    }

    @Test
    public void 자동차_이름이_5자보다_큰경우_테스트() throws Exception {
        //given
        String input1 = "Faker,Zeus,Uzi";
        String input2 = "Kkoma,ShowMaker,";

        //when
        Separator sepator = new Separator();

        //then
        List<Car> cars1 = sepator.separateCars(input1);
        assertEquals(cars1.size(), 3);
        assertThrows(IllegalArgumentException.class, ()-> sepator.separateCars(input2), Message.CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE.getMessage());
    }
    @Test
    public void 자동차_이름이_중복되는_경우_테스트() throws Exception{
        //given
        String input = "Faker,Uzi,Faker";

        //when
        Separator sepator = new Separator();

        //then
        assertThrows(IllegalArgumentException.class,()->sepator.separateCars(input), Message.CAR_NAME_DUPLICATE_VALIDATION_MESSAGE.getMessage());

    }

}