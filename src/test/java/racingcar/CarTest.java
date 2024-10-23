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

        CarList list1 = new CarList();
        list1.add(case1);

        CarList list2 = new CarList();
        list2.add(case2);

        //when

        List<Car> carList1 = list1.getList();
        List<Car> carList2 = list2.getList();

        //then
        Assertions.assertAll(
                () -> assertEquals(3, carList1.size()),
                () -> assertEquals(1, carList2.size()),
                () -> assertEquals(carList1.getFirst().getName(), "pobi")
        );

    }

    @Test
    void createCar_exception() {
        //given
        String case1 = "hello";
        String case2 = "helloWorld";

        CarList manager1 = new CarList();
        manager1.add(case1);

        CarList manager2 = new CarList();

        //when // then
        Assertions.assertAll(
                () -> assertEquals(1, manager1.getList().size()),
                () -> assertThrows(IllegalArgumentException.class, () -> manager2.add(case2))
        );

    }
}