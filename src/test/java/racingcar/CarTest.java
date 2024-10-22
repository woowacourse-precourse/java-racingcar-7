package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @DisplayName("이동해야 할 수가 4 이상일 경우 자동차는 전진한다.")
    @Test
    void moveCar(){
        //Arrange
        int moveNumber = 4;
        Car car = new Car("je");

        //Act
        car.move(moveNumber);

        //Assert
        assertEquals(4, car.getMovedNumber());
    }

    @DisplayName("이동해야 할 수가 4 이상이 아닐 경우 자동차는 전진하지 않는다.")
    @Test
    void notMoveCar(){
        //Arrange
        int move = 3;
        Car car = new Car("je");

        //Act
        car.move(move);

        //Assert
        assertEquals(0, car.getMovedNumber());
    }
}
