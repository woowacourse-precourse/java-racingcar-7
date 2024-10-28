package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    NumberGenerator moveGenerator = () -> 4;
    NumberGenerator stopGenerator = () -> 3;

    @DisplayName("레이스 생성 성공")
    @Test
    void parseCarNamesTest() {
        String rawCarNames = "pobi,woni";

        Race race = new Race(rawCarNames, stopGenerator);

        Assertions.assertThat(race.getCars().get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(race.getCars().get(1).getName()).isEqualTo("woni");
    }

    @DisplayName("레이스 생성 실패")
    @Test
    void validateDuplicatesTest() {
        String rawCarNames = "pobi,pobi,woni";

        Assertions.assertThatThrownBy(() -> new Race(rawCarNames, stopGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 차 이름이 있습니다.");
    }

    @DisplayName("우승자 판별 성공")
    @Test
    void findWinnersTest() {
        Race race = new Race("pobi,woni", moveGenerator);

        race.getCars().get(0).move();
        List<Car> winners = race.findWinners();

        Assertions.assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }
}
