package racingcar.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CompareTest {

    Compare compare = new Compare();

    @Test
    void maxPosition() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        for (int i = 0; i < 5; i++) {
            car1.move();
            car2.move();
            car3.move();
        }

        //when
        int maxPosition = compare.maxPosition(List.of(car1, car2, car3));

        //then
        int moveLength1 = car1.getMoveHistory().length();
        int moveLength2 = car2.getMoveHistory().length();
        int moveLength3 = car3.getMoveHistory().length();

        int expected = Math.max(moveLength1, Math.max(moveLength2, moveLength3));

        assertEquals(expected, maxPosition);
    }

    @Test
    void winnerName() {
        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        for (int i = 0; i < 5; i++) {
            car1.move();
            car2.move();
            car3.move();
        }

        //when
        List<Car> cars = List.of(car1, car2, car3);

        //then
        int moveLength1 = car1.getMoveHistory().length();
        int moveLength2 = car2.getMoveHistory().length();
        int moveLength3 = car3.getMoveHistory().length();

        int maxPosition = Math.max(moveLength1, Math.max(moveLength2, moveLength3));

        List<String> expected = new ArrayList<>();
        for (Car tempCar : cars) {
            if (tempCar.getMoveHistory().length() == maxPosition) {
                expected.add(tempCar.getName());
            }
        }

        assertEquals(expected, compare.winnerName(cars));
    }
}