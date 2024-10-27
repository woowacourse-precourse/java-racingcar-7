package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    @DisplayName("자동차 이름 분리 성공")
    @Test
    void parseCarNamesTest() {
        String rawCarNames = "pobi,woni";

        Race race = new Race(rawCarNames);

        Assertions.assertThat(race.getCars().get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(race.getCars().get(1).getName()).isEqualTo("woni");
    }

    @DisplayName("우승자 판별 성공")
    @Test
    void findWinnersTest() {
        Race race = new Race("pobi,woni");

        race.getCars().get(0).move();
        List<Car> winners = race.findWinners();

        Assertions.assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }
}
