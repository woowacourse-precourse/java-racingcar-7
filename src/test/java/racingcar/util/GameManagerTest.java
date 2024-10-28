package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class GameManagerTest {

    @Test
    void setCars() {
        GameManager gameManager = new GameManager();
        String input = "CarA,CarB,CarC";
        ArrayList<Car> cars = gameManager.setCars(input);

        assertThat(cars).hasSize(3);
        assertThat(cars).extracting("name").containsExactlyInAnyOrder("CarA", "CarB", "CarC");
        assertThat(cars).extracting("distance").containsExactlyInAnyOrder(0, 0, 0);
    }


    @Test
    void getWinner() {
        GameManager gameManager = new GameManager();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Car A", 10));
        cars.add(new Car("Car B", 20));
        cars.add(new Car("Car C", 30));

        ArrayList<Car> winners = gameManager.getWinner(cars);
        assertThat(winners).hasSize(1);
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("Car C");

        cars.add(new Car("Car D", 30));
        winners = gameManager.getWinner(cars);
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("Car C", "Car D");
    }
}