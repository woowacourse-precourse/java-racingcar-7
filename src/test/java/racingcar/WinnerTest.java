package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {
    @DisplayName("단독 우승자를 찾아낸다")
    @Test
    void findSoleWinner(){
        //Arrange
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car("car1", new CarNameValidator()),
                new Car("car2", new CarNameValidator())
        ));
        cars.get(0).move(4);
        cars.get(1).move(7);
        Winner winner = new Winner();

        //Act
        List<String> findWinner = winner.findWinner(cars);

        //Assert
        assertThat(findWinner).isEqualTo(Arrays.asList("car2"));

    }

    @DisplayName("공동 우승자를 찾아낸다")
    @Test
    void findJointWinner(){
        //Arrange
        List<Car> cars = new ArrayList<>(Arrays.asList(
                new Car("car1", new CarNameValidator()),
                new Car("car2", new CarNameValidator())
        ));
        cars.get(0).move(7);
        cars.get(1).move(7);
        Winner winner = new Winner();

        //Act
        List<String> findWinner = winner.findWinner(cars);

        //Assert
        assertThat(findWinner).isEqualTo(Arrays.asList("car1","car2"));

    }
}
