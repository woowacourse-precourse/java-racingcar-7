package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"jenny", "a b", "./3"})
    @DisplayName("유효성 검사에 통과한 자동차 이름은 자동차가 생성된다.")
    void makeCar(String name){

        //Act
        Car car = new Car(name, new CarNameValidator());

        //Assert
        assertThat(car).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"christine", "", " "})
    @DisplayName("유효성 검사에 통과하지 못한 자동차 이름은 자동차가 생성되지 않는다.")
    void cannotMakeCar(String name){
        //Act
        assertThatThrownBy(()-> {
            new Car(name, new CarNameValidator());
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("이동해야 할 수가 4 이상일 경우 자동차는 전진한다.")
    void moveCar(int moveNumber){
        //Arrange
        Car car = new Car("je", new CarNameValidator());

        //Act
        car.move(moveNumber);

        //Assert
        assertEquals(moveNumber, car.getMovedNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("이동해야 할 수가 4 이상이 아닐 경우 자동차는 전진하지 않는다.")
    void notMoveCar(int moveNumber){
        //Arrange
        Car car = new Car("je", new CarNameValidator());

        //Act
        car.move(moveNumber);

        //Assert
        assertEquals(0, car.getMovedNumber());
    }

    @Test
    @DisplayName("자동차가 이동한 수가 maxMovedNumber라면 winner가 됨")
    void judgeWinner(){
        //Arrange
        Car car = new Car("je", new CarNameValidator());
        car.move(7);
        int maxMovedNumber = 7;

        //Act
        boolean isWinner = car.isWinner(maxMovedNumber);

        //Assert
        assertEquals(true, isWinner);
    }
}
