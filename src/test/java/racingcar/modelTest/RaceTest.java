package racingcar.modelTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @Test
    @DisplayName("Race 생성 성공")
    void createRaceWithValidNames() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        assertThatNoException()
                .isThrownBy(() -> new Race(names));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("자동차 이름 목록이 비어있는 경우")
    void createRaceWithEmptyOrNullException(List<String> names) {
        assertThatThrownBy(() -> new Race(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("한 라운드를 정상적으로 실행")
    void playRoundSuccessfully() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Race race = new Race(names);
        race.playRound(); // 실제 게임의 랜덤 요소는 테스트에 포함시키지 않습니다
        assertThat(race.getCars()).allSatisfy(car -> {
            assertThat(car.getPosition()).isBetween(0, 1); // 각 자동차는 전진하거나 그대로일 수 있습니다
        });
    }

    @Test
    @DisplayName("우승자 판별")
    void determineWinners() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Race race = new Race(names);
        race.getCars().get(0).move(4); // pobi만 전진
        race.getCars().get(1).move(3); // crong은 전진하지 않음
        race.getCars().get(2).move(4); // honux만 전진

        assertThat(race.getWinners()).containsExactlyInAnyOrder("pobi", "honux");
    }

    @Test
    @DisplayName("최대 위치 찾기")
    void findMaxPosition() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");
        Race race = new Race(names);
        race.getCars().get(0).move(4); // pobi만 전진
        race.getCars().get(1).move(3); // crong은 전진하지 않음
        race.getCars().get(2).move(4); // honux만 전진

        assertThat(race.getCars().stream().mapToInt(Car::getPosition).max().orElse(0)).isEqualTo(1);
    }
}
