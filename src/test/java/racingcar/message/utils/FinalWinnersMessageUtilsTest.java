package racingcar.message.utils;

import org.junit.jupiter.api.Test;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.message.utils.FinalWinnersMessageUtils;

import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalWinnersMessageUtilsTest {

    @Test
    void TDD_단일_우승자_메세지() {
        //given
        String racingCars = "pobi,woni";
        String tryCount = "5";

        Racing racing = Racing.of(racingCars, tryCount);

        IntStream.rangeClosed(1, racing.tryCount().getCount())
                .forEach(i -> raceByStep(racing, this::isCarNamePobi));

        //when
        String message = FinalWinnersMessageUtils.winnersMessage(racing.getWinners());

        //then
        assertThat(message).isEqualTo("최종 우승자: pobi");
    }

    @Test
    void TDD_공동_우승자_메세지() {
        //given
        String racingCars = "pobi,woni";
        String tryCount = "5";

        Racing racing = Racing.of(racingCars, tryCount);

        IntStream.rangeClosed(1, racing.tryCount().getCount())
                .forEach(i -> raceByStep(racing, this::isTrue));

        //when
        String message = FinalWinnersMessageUtils.winnersMessage(racing.getWinners());

        //then
        assertThat(message).isEqualTo("최종 우승자: pobi, woni");
    }

    private void raceByStep(Racing racing, Predicate<RacingCar> carNameFilter) {
        racing.racingCars().getCars().stream()
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
