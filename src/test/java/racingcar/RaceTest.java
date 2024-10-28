package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race(List.of("pobi", "crong", "honux"), 3);
    }

    @Test
    void raceInitializationTest() {
        List<Car> cars = race.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("crong");
        assertThat(cars.get(2).getName()).isEqualTo("honux");
        assertThat(cars.stream().allMatch(car -> car.getPosition() == 0)).isTrue();
    }

    @Test
    void getWinnersTest() {
        List<Car> cars = race.getCars();
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(2).move();

        List<String> winners = race.getWinners();
        assertThat(winners).containsExactly("pobi");
    }
}