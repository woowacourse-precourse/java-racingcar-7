package racingcar.domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {

    NumberGenerator forwardGenerator = () -> 4;
    NumberGenerator stopGenerator = () -> 3;

    @DisplayName("레이스 생성 성공")
    @Test
    void raceTest() {
        List<String> carNames = List.of("pobi", "woni");

        Assertions.assertThatCode(() -> new Race(carNames, stopGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이스 생성 실패 : 중복된 자동차 이름")
    @Test
    void validateDuplicatesTest() {
        List<String> carNames = List.of("pobi", "pobi", "woni");

        Assertions.assertThatThrownBy(() -> new Race(carNames, stopGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 차 이름이 있습니다.");
    }

    @DisplayName("우승자 판별 성공")
    @Test
    void findWinnersTest() {
        List<String> carNames = List.of("pobi", "woni");

        Race race = new Race(carNames, forwardGenerator);

        race.getCars().get(0).move();
        List<Car> winners = race.findWinners();

        Assertions.assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }
}
