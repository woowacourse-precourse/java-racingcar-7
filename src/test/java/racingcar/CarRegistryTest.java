package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.CarRegistry;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarRegistryTest {

    @Test
    @DisplayName("차의 이름이 맞는지 검증")
    void testValidCarNames() {
        // Given
        String input = "pobi,woni,jun";

        // When
        CarFactory carFactory = new CarFactory();
        CarRegistry carRegistry = new CarRegistry(carFactory.createCars(input));
        Set<Car> expectedCars = new HashSet<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));
        expectedCars.add(new Car("jun"));

        // Then
        assertEquals(expectedCars.size(), carRegistry.getCars().size());
        assertTrue(carRegistry.getCars().containsAll(expectedCars));
    }

    @Test
    @DisplayName("중복된 이름이 걸러져서 나오는지 테스트")
    void testDuplicateCarNames() {
        // Given
        String input = "pobi,woni,pobi";

        // When
        CarFactory carFactory = new CarFactory();
        CarRegistry carRegistry = new CarRegistry(carFactory.createCars(input));
        Set<Car> expectedCars = new HashSet<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));

        // Then
        assertEquals(expectedCars.size(), carRegistry.getCars().size());
        assertTrue(carRegistry.getCars().containsAll(expectedCars));
    }

    @Test
    @DisplayName("하나의 이름이 너무 클 때, 오류를 반환하는지 확인")
    void testInvalidCarNameTooLong() {
        // Given
        String input = "pobi,woni,pobi Maguire"; // One name too long
        CarFactory carFactory = new CarFactory();

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> carFactory.createCars(input));

        // Then
        assertEquals("Car name has to be 5 or under 5.", exception.getMessage());
    }
}
