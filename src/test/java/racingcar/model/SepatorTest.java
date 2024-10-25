package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class SepatorTest {

    @Test
    public void 분리기_정상_테스트() throws Exception{
        //given
        String input = "pobi,woni, jun";

        //when
        Sepator sepator = new Sepator();
        List<Car> cars = sepator.separateCars(input);

        //then
        Assertions.assertEquals(cars.size(), 3);
        Assertions.assertEquals(cars.get(0).getName(), "pobi");
        Assertions.assertEquals(cars.get(1).getName(), "woni");
        Assertions.assertEquals(cars.get(2).getName(), " jun");
    }
}