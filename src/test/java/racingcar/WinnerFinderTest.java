package racingcar;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class WinnerFinderTest {

    @Test
    public void 우승자_1명() {
        RacingCar car1 = new TestRacingCar("Car1", 5);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        List<String> winners = WinnerFinder.findWinner(cars);

        assertEquals(1, winners.size());
        assertEquals("Car1", winners.getFirst());
    }

    @Test
    public void 우승자_여러명() {
        RacingCar car1 = new TestRacingCar("Car1", 5);
        RacingCar car2 = new TestRacingCar("Car2", 3);
        RacingCar car3 = new TestRacingCar("Car3", 5);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        List<String> winners = WinnerFinder.findWinner(cars);

        assertEquals(2, winners.size());
        assertThat(winners).containsExactlyInAnyOrder("Car1", "Car3");
    }

    @Test
    public void 우승자_없음() {
        List<RacingCar> cars = new ArrayList<>();
        List<String> winners = WinnerFinder.findWinner(cars);

        assertEquals(0, winners.size());
    }

    @Test
    public void 모두_동점() {
        RacingCar car1 = new TestRacingCar("Car1", 2);
        RacingCar car2 = new TestRacingCar("Car2", 2);
        RacingCar car3 = new TestRacingCar("Car3", 2);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        List<String> winners = WinnerFinder.findWinner(cars);

        assertEquals(3, winners.size());
        assertThat(winners).contains("Car1", "Car2", "Car3");
    }

    @Test
    public void 모두_위치0() {
        RacingCar car1 = new TestRacingCar("Car1", 0);
        RacingCar car2 = new TestRacingCar("Car2", 0);
        RacingCar car3 = new TestRacingCar("Car3", 0);

        List<RacingCar> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        List<String> winners = WinnerFinder.findWinner(cars);

        assertEquals(3, winners.size());
        assertThat(winners).contains("Car1", "Car2", "Car3");
    }
}