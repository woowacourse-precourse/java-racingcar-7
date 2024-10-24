package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        CarRegistry carRegistry = new CarRegistry(input);
        Set<Car> expectedCars = new HashSet<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));
        expectedCars.add(new Car("jun"));

        // Then
        assertEquals(expectedCars.size(), carRegistry.getCars().size());
        assertTrue(carRegistry.getCars().containsAll(expectedCars));
    }

    @Test
    void testDuplicateCarNames() {
        // Given
        String input = "pobi,woni,pobi";

        // When
        CarRegistry carRegistry = new CarRegistry(input);
        Set<Car> expectedCars = new HashSet<>();
        expectedCars.add(new Car("pobi"));
        expectedCars.add(new Car("woni"));

        // Then
        assertEquals(expectedCars.size(), carRegistry.getCars().size());
        assertTrue(carRegistry.getCars().containsAll(expectedCars));
    }

    @Test
    void testEmptyInput() {
        // Given
        String input = "";

        // When
        CarRegistry carRegistry = new CarRegistry(input);

        // Then
        assertTrue(carRegistry.getCars().isEmpty());
    }

    @Test
    void testInvalidCarNameTooLong() {
        // Given
        String input = "pobi,woni,pobi Maguire"; // One name too long

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new CarRegistry(input));

        // Then
        assertEquals("Car name has to be 5 or under 5.", exception.getMessage());
    }
}
