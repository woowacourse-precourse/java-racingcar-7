package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarListTest {
    private RacingCarList racingCarList;

    @BeforeEach
    void setUp() {
        racingCarList = new RacingCarList();
    }

    @Test
    void add_ValidCarNames_ShouldAddCars() {
        // GIVEN
        String carNames = "car1,car2,car3";

        // WHEN
        racingCarList.add(carNames);
        List<Car> cars = racingCarList.moveCar("1");

        // THEN
        assertEquals(3, cars.size());
        assertEquals("car1", cars.get(0).getName());
        assertEquals("car2", cars.get(1).getName());
        assertEquals("car3", cars.get(2).getName());
    }

    @Test
    void add_InvalidCarName_ShouldThrowException() {
        // GIVEN
        String carNames = "validCarName,invalidCarNameThatIsTooLong";

        // WHEN & THEN
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            racingCarList.add(carNames);
        });

        String expectedMessage = "자동차 이름은 5자 이하만 가능합니다";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void moveCar_ShouldMoveCarsCorrectly() {
        // GIVEN
        racingCarList.add("car1,car2");

        // WHEN
        racingCarList.moveCar("3");
        List<Car> cars = racingCarList.moveCar("3");

        // THEN
        assertEquals(2, cars.size());
        assertTrue(cars.get(0).getPosition() >= 0);
        assertTrue(cars.get(1).getPosition() >= 0);
    }
}
