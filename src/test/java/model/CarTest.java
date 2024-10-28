package model;

import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private Car car;
    private String name;

    @BeforeEach
    void setUp() {
        car = new Car(name);
    }

    @ParameterizedTest
    @DisplayName("이름이 정상적으로 설정되었습니다.")
    @ValueSource(strings = {"pobi"})
    void testCarNameLength(String carName) {
        Car car = new Car(carName);
        assertEquals(carName, car.getName());
    }

    @Test
    void testMoveForward() {
        Car car = new Car("Test");
        int initialPosition = car.getPosition();
        car.moveForward();
        assertEquals(initialPosition + 1, car.getPosition());
    }
}
