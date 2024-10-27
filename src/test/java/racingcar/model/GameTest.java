package racingcar.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {
    @Test
    void 우승차_찾기() {
        //Given
        SoftAssertions softly = new SoftAssertions();
        Game game = new Game();
        Cars cars = new Cars("car1, car2, car3");
        int i = 0;
        for (Car car : cars.getCarGroup()) {
            if (car.getName().equals("car1")) car.settingPosition(1);
            if (car.getName().equals("car2")) car.settingPosition(3);
            if (car.getName().equals("car3")) car.settingPosition(3);
        }

        //When
        List<Car> winningCarGroup = game.findWinningCars(cars);

        //Then
        softly.assertThat(winningCarGroup.size()).isEqualTo(2);
        softly.assertThat(winningCarGroup.get(0).getName()).isEqualTo("car2");
        softly.assertThat(winningCarGroup.get(1).getName()).isEqualTo("car3");
        softly.assertAll();
    }
}
