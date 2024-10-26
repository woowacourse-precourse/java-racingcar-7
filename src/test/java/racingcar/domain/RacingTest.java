package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.RacingConstant.RACING_CAR_MOVE_LIMIT;

public class RacingTest {

    @Test
    void TDD_레이싱_객체_초기화() {
        //given
        LinkedHashSet<RacingCar> cars = Stream.of("pobi", "woni")
                .map(RacingCar::new)
                .collect(toCollection(LinkedHashSet::new));
        int tryCount = 5;

        //when
        Racing racing = new Racing(cars, tryCount);

        //then
        assertThat(racing.cars()).isEqualTo(cars);
        assertThat(racing.tryCount()).isEqualTo(tryCount);
    }

    @Test
    void TDD_정적_팩토리_메서드_of() {
        //given
        LinkedHashSet<RacingCar> cars = Stream.of("pobi", "woni")
                .map(RacingCar::new)
                .collect(toCollection(LinkedHashSet::new));
        int tryCount = 5;

        //when
        Racing racing = Racing.of(cars, tryCount);

        //then
        assertThat(racing.cars()).isEqualTo(cars);
        assertThat(racing.tryCount()).isEqualTo(tryCount);
    }

    @Test
    void TDD_경주_우승자_찾기() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        RacingCar woni = new RacingCar("woni");

        //when
        pobi.move(RACING_CAR_MOVE_LIMIT);

        LinkedHashSet<RacingCar> cars = Stream.of(pobi, woni).collect(toCollection(LinkedHashSet::new));

        Racing racing = Racing.of(cars, 5);
        List<RacingCar> winners = racing.getWinners();

        //then
        assertThat(winners).extracting(RacingCar::getName).containsExactly("pobi");
        assertThat(winners).extracting(RacingCar::getPosition).containsExactly(1);
    }

    @Test
    void TDD_경주_공동_우승자_찾기() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        RacingCar woni = new RacingCar("woni");

        //when
        pobi.move(RACING_CAR_MOVE_LIMIT);
        woni.move(RACING_CAR_MOVE_LIMIT);

        LinkedHashSet<RacingCar> cars = Stream.of(pobi, woni).collect(toCollection(LinkedHashSet::new));

        Racing racing = Racing.of(cars, 5);
        List<RacingCar> winners = racing.getWinners();

        //then
        assertThat(winners).extracting(RacingCar::getName).containsExactly("pobi", "woni");
        assertThat(winners).extracting(RacingCar::getPosition).containsExactly(1, 1);
    }
}
