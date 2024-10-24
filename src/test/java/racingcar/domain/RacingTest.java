package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.input.converter.InputToRacingCarsConverter;
import racingcar.input.converter.InputToRacingTryCountConverter;

import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    InputToRacingCarsConverter inputToRacingCarsConverter;
    InputToRacingTryCountConverter inputToRacingTryCountConverter;

    @BeforeEach
    void before() {
        inputToRacingCarsConverter = new InputToRacingCarsConverter();
        inputToRacingTryCountConverter = new InputToRacingTryCountConverter();
    }

    @Test
    void TDD_레이싱_객체_초기화() {
        //given
        LinkedList<RacingCar> cars = inputToRacingCarsConverter.convert("pobi,woni");
        int tryCount = inputToRacingTryCountConverter.convert("5");

        //when
        Racing racing = new Racing(cars, tryCount);

        //then
        assertThat(racing.cars()).isEqualTo(cars);
        assertThat(racing.tryCount()).isEqualTo(tryCount);
    }

    @Test
    void TDD_정적_팩토리_메서드_of() {
        //given
        LinkedList<RacingCar> cars = inputToRacingCarsConverter.convert("pobi,woni");
        int tryCount = inputToRacingTryCountConverter.convert("5");

        //when
        Racing racing = Racing.of(cars, tryCount);

        //then
        assertThat(racing.cars()).isEqualTo(cars);
        assertThat(racing.tryCount()).isEqualTo(tryCount);
    }

    @Test
    void TDD_경주_우승자_찾기() {
        //given
        Racing racing = initRacing();

        //when
        raceStartWithCarFilter(racing, this::isCarNamePobi);

        //then
        assertThat(racing.getWinners()).extracting(RacingCar::getName).containsExactly("pobi");
        assertThat(racing.getWinners()).extracting(RacingCar::getPosition).containsExactly(5);
    }

    @Test
    void TDD_경주_공동_우승자_찾기() {
        //given
        Racing racing = initRacing();

        //when
        raceStartWithCarFilter(racing, this::isTrue);

        //then
        assertThat(racing.getWinners()).extracting(RacingCar::getName).containsExactly("pobi", "woni");
        assertThat(racing.getWinners()).extracting(RacingCar::getPosition).containsExactly(5, 5);
    }

    private Racing initRacing() {
        LinkedList<RacingCar> cars = inputToRacingCarsConverter.convert("pobi,woni");
        int tryCount = inputToRacingTryCountConverter.convert("5");

        return Racing.of(cars, tryCount);
    }

    private void raceStartWithCarFilter(Racing racing, Predicate<RacingCar> carFilter) {
        IntStream.rangeClosed(1, racing.tryCount()).forEach(i -> raceByStep(racing, carFilter));
    }

    private void raceByStep(Racing racing, Predicate<RacingCar> carFilter) {
        racing.cars().stream()
                .filter(carFilter)
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
