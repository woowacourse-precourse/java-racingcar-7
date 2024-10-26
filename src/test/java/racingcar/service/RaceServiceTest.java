package racingcar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        this.raceService = new RaceService();
    }

    @DisplayName("자동차 이름을 쉼표 기준으로 분리하는 기능 테스트")
    @Test
    public void splitCarNamesTest() {
        String[] carNames = raceService.splitCarNames("pobi,won,juni");
        assertEquals(carNames[0], "pobi");
        assertEquals(carNames[1], "won");
        assertEquals(carNames[2], "juni");
    }

    @DisplayName("우승자 결정하는 기능 테스트")
    @Test
    public void decisionWinnersTest() {
        List<Car> Cars = new ArrayList<>();
        Cars.add(new Car("pobi"));
        Cars.add(new Car("won"));
        Cars.add(new Car("juni"));
        Cars.get(0).move();
        Cars.get(0).move();
        Cars.get(1).move();
        Cars.get(2).move();
        Cars.get(2).move();
        String[] winners = raceService.decisionWinners();
        assertEquals(winners, "pobi,juni");
    }
}
