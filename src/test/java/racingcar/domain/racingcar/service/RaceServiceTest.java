package racingcar.domain.racingcar.service;

import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.racingcar.domain.Car;
import racingcar.domain.racingcar.domain.Race;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = RaceServiceImpl.getInstance();
    }

    @Nested
    @DisplayName("경주 생성 테스트")
    class CreateRaceTest {

        @Test
        @DisplayName("유효한 입력으로 경주를 생성한다")
        void createRaceWithValidInput() {
            // given
            List<String> carNames = Arrays.asList("car1", "car2", "car3");
            int rounds = 5;

            // when
            Race race = raceService.createRace(carNames, rounds);

            // then
            assertThat(race).isNotNull();
            assertThat(race.getCars()).hasSize(3);
            assertThat(race.getTotalRounds()).isEqualTo(rounds);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -5})
        @DisplayName("라운드 수가 1 미만이면 예외를 발생시킨다")
        void throwExceptionForInvalidRounds(int invalidRounds) {
            // given
            List<String> carNames = Arrays.asList("car1", "car2");

            // when & then
            assertThatThrownBy(() -> raceService.createRace(carNames, invalidRounds))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
        }

        @Test
        @DisplayName("자동차 이름이 5자를 초과하면 예외를 발생시킨다")
        void throwExceptionForLongCarName() {
            // given
            List<String> carNames = Arrays.asList("car1", "car2", "toolongname");

            // when & then
            assertThatThrownBy(() -> raceService.createRace(carNames, 5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("자동차 이름은 5자 이하여야 합니다");
        }
    }


    @Nested
    @DisplayName("경주 진행 테스트")
    class RaceProgressTest {

        private Race race;

        @BeforeEach
        void setUp() {
            race = raceService.createRace(Arrays.asList("car1", "car2"), 3);
        }

        @Test
        @DisplayName("모든 자동차를 이동시킨다")
        void moveAllCars() {
            // given
            List<Integer> initialPositions = race.getCars().stream()
                    .map(Car::getPosition)
                    .collect(Collectors.toList());

            // when
            raceService.moveAllCars(race);

            // then
            List<Integer> newPositions = race.getCars().stream()
                    .map(Car::getPosition)
                    .collect(Collectors.toList());

            assertThat(newPositions).isNotEqualTo(initialPositions);
        }

        @Test
        @DisplayName("경주 상태를 정확히 반환한다")
        void getRaceStatus() {
            // when
            List<String> status = raceService.getRaceStatus(race);

            // then
            assertThat(status).hasSize(2);
            assertThat(status).allMatch(s -> s.startsWith("car1 : ") || s.startsWith("car2 : "));
            assertThat(status).allMatch(s -> s.substring(s.indexOf(":") + 2).matches("-*"));
        }

        @Test
        @DisplayName("우승자를 정확히 결정한다")
        void getWinnerNames() {
            // given
            while (race.getWinners().size() != 1) {
                raceService.moveAllCars(race);
            }

            // when
            List<String> winners = raceService.getWinnerNames(race);

            // then
            assertThat(winners).hasSize(1);
            assertThat(winners).isSubsetOf("car1", "car2");
        }
    }
}