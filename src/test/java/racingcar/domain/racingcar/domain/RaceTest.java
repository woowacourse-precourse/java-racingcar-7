package racingcar.domain.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @Nested
    @DisplayName("Race 객체 생성 테스트")
    class RaceCreationTest {

        @ParameterizedTest
        @CsvSource({
                "'car1,car2,car3',5",
                "'pobi,woni,jun',3",
                "'a,b,c,d,e',10"
        })
        @DisplayName("정상적으로 Race 객체를 생성한다")
        void createRace(String carNamesCSV, int totalRounds) {
            // given
            List<String> carNames = Arrays.asList(carNamesCSV.split(","));

            // when & then
            assertThat(Race.of(carNames, totalRounds)).isNotNull();
        }

        @ParameterizedTest
        @CsvSource({
                "'car1,car2',0",
                "'pobi,woni',-1",
                "'a,b,c',-5"
        })
        @DisplayName("시도 횟수가 1 미만이면 예외를 발생시킨다")
        void validateRoundsException(String carNamesCSV, int invalidRounds) {
            // given
            List<String> carNames = Arrays.asList(carNamesCSV.split(","));

            // when & then
            assertThatThrownBy(() -> Race.of(carNames, invalidRounds))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    @Nested
    @DisplayName("Race 진행 테스트")
    class RaceProgressTest {

        @ParameterizedTest
        @CsvSource({
                "'car1,car2',3",
                "'pobi,woni,jun',5"
        })
        @DisplayName("모든 자동차를 이동시킨다")
        void move(String carNamesCSV, int totalRounds) {
            // given
            List<String> carNames = Arrays.asList(carNamesCSV.split(","));
            Race race = Race.of(carNames, totalRounds);

            // when
            race.moveAllCars();

            // then
            assertThat(race.getCars()).allSatisfy(car ->
                    assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
            );
        }

        @ParameterizedTest
        @CsvSource({
                "'car1,car2',3",
                "'pobi,woni,jun',5"
        })
        @DisplayName("정해진 라운드가 끝나면 경주가 종료된다")
        void raceFinish(String carNamesCSV, int totalRounds) {
            // given
            List<String> carNames = Arrays.asList(carNamesCSV.split(","));
            Race race = Race.of(carNames, totalRounds);

            // when
            for (int i = 0; i < totalRounds; i++) {
                race.moveAllCars();
            }

            // then
            assertThat(race.isRaceFinished()).isTrue();
        }
    }

    @Test
    @DisplayName("우승자를 정확히 결정한다")
    void determineWinner() {
        // given
        Race race = Race.of(Arrays.asList("car1", "car2", "car3"), 5);

        // 실제 경주 시뮬레이션
        while (!race.isRaceFinished()) {
            race.moveAllCars();
        }

        // when
        List<Car> winners = race.getWinners();

        // then
        assertThat(winners).isNotEmpty();
        assertThat(winners).allMatch(car -> car.getPosition() == winners.get(0).getPosition());

        // 모든 차들 중 우승자의 위치가 가장 앞서 있는지 확인
        int winningPosition = winners.get(0).getPosition();
        assertThat(race.getCars())
                .allMatch(car -> car.getPosition() <= winningPosition);
    }
}