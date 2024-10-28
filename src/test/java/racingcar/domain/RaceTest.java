package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(String.join(", ",winners), "pobi, juni");
    }
}
