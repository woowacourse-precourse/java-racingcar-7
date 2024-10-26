package racingcar.message.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.converter.StringToRacingCarsConverter;
import racingcar.converter.StringToRacingTryCountConverter;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;

import java.util.LinkedHashSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalWinnersMessageUtilsTest {

    StringToRacingCarsConverter stringToRacingCarsConverter;
    StringToRacingTryCountConverter stringToRacingTryCountConverter;

    @BeforeEach
    void before() {
        stringToRacingCarsConverter = new StringToRacingCarsConverter();
        stringToRacingTryCountConverter = new StringToRacingTryCountConverter();
    }

    @Test
    void TDD_단일_우승자_메세지() {
        //given
        Racing racing = initRacing();
        raceStartWithCarFilter(racing, this::isCarNamePobi);

        //when
        String message = FinalWinnersMessageUtils.generateFinalWinnersMessage(racing.getWinners());

        //then
        assertThat(message).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void TDD_공동_우승자_메세지() {
        //given
        Racing racing = initRacing();

        raceStartWithCarFilter(racing, this::isTrue);

        //when
        String message = FinalWinnersMessageUtils.generateFinalWinnersMessage(racing.getWinners());

        //then
        assertThat(message).isEqualTo("최종 우승자 : pobi, woni");
    }

    private Racing initRacing() {
        LinkedHashSet<RacingCar> cars = stringToRacingCarsConverter.convert("pobi,woni");
        int tryCount = stringToRacingTryCountConverter.convert("5");

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
