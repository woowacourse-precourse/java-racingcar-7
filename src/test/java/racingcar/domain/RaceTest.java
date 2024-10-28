package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("우승자 결정하는 기능 테스트")
    @Test
    public void decisionWinnersTest() {
        List<Car> Cars = new ArrayList<>();
        Cars.add(new Car("pobi"));
        Cars.add(new Car("won"));
        Cars.add(new Car("juni"));

        Race race = new Race(Cars, 5);

        Cars.get(0).move();
        Cars.get(0).move();
        Cars.get(1).move();
        Cars.get(2).move();
        Cars.get(2).move();

        List<String> winners = race.getWinners();
        assertEquals(String.join(", ", winners), "pobi, juni");
    }

    @DisplayName("경주 종료 후 우승자가 올바르게 결정되는지 테스트")
    @Test
    public void winnersNotNullTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("won"));
        cars.add(new Car("juni"));

        Race race = new Race(cars, 3);
        for (int i = 0; i < 3; i++) {
            race.playOneRound();
        }

        List<String> winners = race.getWinners();

        assertFalse(winners.isEmpty());
    }

    @DisplayName("시도 횟수가 0 미만일 때 예외를 발생시키는지 테스트")
    @Test
    public void invalidTryCountTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));

        IllegalArgumentException thrown = org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Race(cars, -1)
        );

        assertEquals("시도할 횟수는 0 이상이어야 합니다.", thrown.getMessage());
    }
}
