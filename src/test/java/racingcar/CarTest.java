package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private Car car;

    @BeforeEach
        void 선언() {
        car = new Car("TestCar");
    }

    @Test
    void 랜덤_숫자() {
        int randomNumber = car.randomNumber();
        assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    void 위치_출력() {
        car.move();
        int carPosition = car.getPosition();
        String positionString = car.printPositionString();
        String correctString = "TestCar : ";
        for(int i = 0; i < carPosition; i++) {
            correctString += "-";
        }
        correctString += "\n";
        assertEquals(positionString, correctString);
    }
}
