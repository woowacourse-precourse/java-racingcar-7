package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    void TDD_레이싱_객체_초기화() {
        //given
        RacingCars racingCars = RacingCars.from("pobi,woni");
        RacingTryCount tryCount = RacingTryCount.from("5");

        //when
        Racing racing = new Racing(racingCars, tryCount);

        //then
        assertThat(racing.getRacingCars()).isEqualTo(racingCars);
        assertThat(racing.getTryCount()).isEqualTo(tryCount);
    }

    @Test
    void TDD_정적_팩토리_메서드_of() {
        //given
        String racingCars = "pobi,woni";
        String tryCount = "5";

        //when
        Racing racing = Racing.of(racingCars, tryCount);

        //then
        assertThat(racing.getRacingCars().getCars()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
        assertThat(racing.getTryCount().getCount()).isEqualTo(5);
    }

    @Test
    void TDD_경주_우승자_찾기() {
        //given
        String racingCars = "pobi,woni";
        String tryCount = "5";

        Racing racing = Racing.of(racingCars, tryCount);

        //when
        IntStream.rangeClosed(1, racing.getTryCount().getCount())
                .forEach(i -> raceByStep(racing, this::isCarNamePobi));

        //then
        assertThat(racing.getWinners()).extracting(RacingCar::getName).containsExactly("pobi");
        assertThat(racing.getWinners()).extracting(RacingCar::getPosition).containsExactly(5);
    }

    @Test
    void TDD_경주_공동_우승자_찾기() {
        //given
        String racingCars = "pobi,woni";
        String tryCount = "5";

        Racing racing = Racing.of(racingCars, tryCount);

        //when
        IntStream.rangeClosed(1, racing.getTryCount().getCount())
                .forEach(i -> raceByStep(racing, this::isTrue));

        //then
        assertThat(racing.getWinners()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
        assertThat(racing.getWinners()).extracting(RacingCar::getPosition).containsExactly(5, 5);
    }

    private void raceByStep(Racing racing, Predicate<RacingCar> carNameFilter) {
        racing.getRacingCars().getCars().stream()
                .filter(carNameFilter)
                .forEach(this::moveCar);
    }

    private void moveCar(RacingCar car) {
        car.move(4);
    }

    private boolean isCarNamePobi(RacingCar car) {
        return car.getName().equals("pobi");
    }

    private boolean isTrue(RacingCar car) {
        return true;
    }
}
