package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void createCar_success() {
        //given
        String case1 = "pobi,woni,jun";
        String case2 = "pobi";

        CarManager manager1 = new CarManager();
        manager1.add(case1);

        CarManager manager2 = new CarManager();
        manager2.add(case2);

        //when

        List<Car> list1 = manager1.getList();
        List<Car> list2 = manager2.getList();

        //then
        Assertions.assertAll(
                () -> assertEquals(3, list1.size()),
                () -> assertEquals(1, list2.size()),
                () -> assertEquals(list1.getFirst().getName(), "pobi")
        );

    }

    @Test
    void createCar_exception() {
        //given
        String case1 = "hello";
        String case2 = "helloWorld";

        CarManager manager1 = new CarManager();
        manager1.add(case1);

        CarManager manager2 = new CarManager();

        //when // then
        Assertions.assertAll(
                () -> assertEquals(1, manager1.getList().size()),
                () -> assertThrows(IllegalArgumentException.class, () -> manager2.add(case2))
        );

    }
}