package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static racingcar.constant.ExceptionMessage.RACE_NOT_FINISHED;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import racingcar.dto.CarsPositionDto;
import racingcar.dto.WinnerNamesDto;
import racingcar.support.AlwaysMovingStrategy;
import racingcar.support.NeverMovingStrategy;
import racingcar.support.SequentialMovingStrategy;
import racingcar.vo.Name;
import racingcar.vo.Round;

class RaceTest {

    @Test
    void 레이스를_초기화한다() {
        // given
        Cars cars = Cars.from(List.of(Car.withName(Name.from("car1"))));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(3));

        // when
        Race race = Race.initializeRace(cars, roundProgress);

        // then
        assertSoftly(softly -> {
            softly.assertThat(race.getEntireHistory())
                    .isEmpty();
            softly.assertThatThrownBy(race::getWinners)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(RACE_NOT_FINISHED.message());
        });
    }

    @Test
    void 모든_자동차가_움직이지_않는_레이스를_실행한다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        ));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(3));
        Race race = Race.initializeRace(cars, roundProgress);

        // when
        race.execute(new NeverMovingStrategy());

        // then
        List<CarsPositionDto> history = race.getEntireHistory();
        assertSoftly(softly -> {
            softly.assertThat(history)
                    .hasSize(3);

            history.forEach(roundResult ->
                    softly.assertThat(roundResult.carPositions())
                            .allMatch(car -> car.position() == 0)
            );
        });
    }

    @Test
    void 모든_자동차가_움직이는_레이스를_실행한다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        ));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(3));
        Race race = Race.initializeRace(cars, roundProgress);

        // when
        race.execute(new AlwaysMovingStrategy());

        // then
        List<CarsPositionDto> history = race.getEntireHistory();
        assertSoftly(softly -> {
            softly.assertThat(history)
                    .hasSize(3);

            for (int i = 0; i < history.size(); i++) {
                int expectedPosition = i + 1;
                softly.assertThat(history.get(i).carPositions())
                        .allMatch(car -> car.position() == expectedPosition);
            }
        });
    }

    @Test
    void 단일_우승자가_있는_레이스를_실행한다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("wi")),
                Car.withName(Name.from("lo"))
        ));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(1));
        Race race = Race.initializeRace(cars, roundProgress);

        // when
        race.execute(SequentialMovingStrategy.sequence(true, false));  // wi는 이동, lo는 정지

        // then
        WinnerNamesDto winners = race.getWinners();
        assertSoftly(softly -> {
            softly.assertThat(winners.winners())
                    .containsExactly("wi");
        });
    }

    @Test
    void 공동_우승자가_있는_레이스를_실행한다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("wi1")),
                Car.withName(Name.from("wi2")),
                Car.withName(Name.from("lo"))
        ));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(1));
        Race race = Race.initializeRace(cars, roundProgress);

        // when
        race.execute(SequentialMovingStrategy.sequence(true, true, false));  // wi1, wi2는 이동, lo는 정지

        // then
        WinnerNamesDto winners = race.getWinners();
        assertSoftly(softly -> {
            softly.assertThat(winners.winners())
                    .containsExactlyInAnyOrder("wi1", "wi2");
        });
    }

    @Test
    void 레이스_진행중_우승자_조회시_예외를_던진다() {
        // given
        Cars cars = Cars.from(List.of(Car.withName(Name.from("car"))));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(2));
        Race race = Race.initializeRace(cars, roundProgress);

        // when & then
        assertThatThrownBy(race::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(RACE_NOT_FINISHED.message());
    }

    @Test
    void 레이스_히스토리가_정확히_기록된다() {
        // given
        Cars cars = Cars.from(List.of(
                Car.withName(Name.from("car1")),
                Car.withName(Name.from("car2"))
        ));
        RoundProgress roundProgress = RoundProgress.createFromTotalRounds(Round.from(2));
        Race race = Race.initializeRace(cars, roundProgress);

        // when
        race.execute(SequentialMovingStrategy.sequence(false, false, true, true));

        // then
        List<CarsPositionDto> history = race.getEntireHistory();
        assertSoftly(softly -> {
            softly.assertThat(history)
                    .hasSize(2);

            // 첫 번째 라운드 (모두 이동 X)
            List<CarPositionDto> round1 = history.get(0).carPositions();
            softly.assertThat(round1)
                    .allMatch(car -> car.position() == 0);

            // 두 번째 라운드 (모두 이동)
            List<CarPositionDto> round2 = history.get(1).carPositions();
            softly.assertThat(round2)
                    .allMatch(car -> car.position() == 1);
        });
    }
}
