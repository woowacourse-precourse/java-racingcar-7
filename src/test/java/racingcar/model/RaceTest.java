package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @DisplayName("기능 테스트: 최종 우승자 명단 생성")
    @Test
    void createWinners() {
        String carNames = "Mary,John,Paul";
        Cars cars = new Cars();
        Race race = new Race();

        cars.createRoundStatus(carNames);
        cars.updateRoundStatus(cars);

        race.createWinners(cars);
        List<String> winners = race.getWinners();

        assertFalse(winners.isEmpty());
    }
}