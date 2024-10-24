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

        CarList list1 = new CarList();
        list1.add(case1);
        //when

        List<Car> carList1 = list1.getList();

        //then
        Assertions.assertAll(
                () -> assertEquals(3, carList1.size()),
                () -> assertEquals(carList1.getFirst().getName(), "pobi")
        );

    }

    @Test
    void createCar_exception() {
        //given
        String case1 = "hello";
        String case2 = "helloWorld";

        CarList manager1 = new CarList();
        CarList manager2 = new CarList();

        //when // then
        Assertions.assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> manager1.add(case1)),
                () -> assertThrows(IllegalArgumentException.class, () -> manager2.add(case2))
        );

    }
}