package racingcar.domain.racingcar.dto;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceStatusTest {

    @ParameterizedTest
    @CsvSource({
            "'car1,car2', 3, 5",
            "'pobi,woni', 1, 3",
            "'a,b,c', 2, 4"
    })
    @DisplayName("RaceStatus 객체가 정상적으로 생성되는지 확인한다")
    void createRaceStatus(String carNames, int currentRound, int totalRounds) {
        // given
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::of)
                .toList();

        // when
        RaceStatus raceStatus = new RaceStatus(cars, currentRound, totalRounds);

        // then
        assertThat(raceStatus.getCarStatuses()).hasSize(cars.size());
        assertThat(raceStatus.getCurrentRound()).isEqualTo(currentRound);
        assertThat(raceStatus.getTotalRounds()).isEqualTo(totalRounds);
    }

    @Test
    @DisplayName("CarStatus 정보가 정확히 반영되는지 확인한다")
    void checkCarStatusInfo() {
        // given
        List<Car> cars = Arrays.asList(Car.of("car1"), Car.of("car2"));
        int currentRound = 3;
        int totalRounds = 5;

        // when
        RaceStatus raceStatus = new RaceStatus(cars, currentRound, totalRounds);

        // then
        assertThat(raceStatus.getCarStatuses()).hasSize(2);
        assertThat(raceStatus.getCurrentRound()).isEqualTo(currentRound);
        assertThat(raceStatus.getTotalRounds()).isEqualTo(totalRounds);

        for (int i = 0; i < cars.size(); i++) {
            RaceStatus.CarStatus carStatus = raceStatus.getCarStatuses().get(i);
            assertThat(carStatus.name()).isEqualTo(cars.get(i).getName());
            assertThat(carStatus.position()).isEqualTo(cars.get(i).getPosition());
        }
    }

    @Test
    @DisplayName("RaceStatus가 불변 객체인지 확인한다")
    void checkRaceStatusImmutability() {
        // given
        List<Car> cars = new ArrayList<>(Arrays.asList(Car.of("car1"), Car.of("car2")));
        RaceStatus raceStatus = new RaceStatus(cars, 1, 5);

        // when
        cars.get(0).move(3);
        cars.add(Car.of("car3"));

        // then
        assertThat(raceStatus.getCarStatuses()).hasSize(2);
        assertThat(raceStatus.getCarStatuses().get(0).position()).isZero();
        assertThat(raceStatus.getCarStatuses()).extracting(RaceStatus.CarStatus::name)
                .containsExactly("car1", "car2");
    }
}