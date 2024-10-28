package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.FinalResultDto;
import racingcar.dto.RoundResultDto;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new CarMover());
    }

    @Test
    void 라운드_수만큼_게임_진행() {
        // given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));
        int roundNumber = 3;

        // when
        FinalResultDto result = racingGame.playRacingGame(roundNumber, carList);

        // then
        assertThat(result.roundResultList()).hasSize(roundNumber);
    }

    @Test
    void 모든_라운드_결과() {
        // given
        List<Car> carList = List.of(new Car("car1"), new Car("car2"));
        int roundNumber = 2;

        // when
        FinalResultDto result = racingGame.playRacingGame(roundNumber, carList);

        // then
        List<RoundResultDto> roundResults = result.roundResultList();
        assertThat(roundResults).hasSize(2);
    }

    @Test
    void 우승자_판단_단일_우승자() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        car1.move();
        carList.add(car1);
        carList.add(car2);

        // when
        FinalResultDto result = racingGame.playRacingGame(0, carList);

        // then
        assertThat(result.winnerList()).containsExactly("car1");
    }

    @Test
    void 우승자_판단_공동_우승자() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        car1.move();
        car2.move();
        carList.add(car1);
        carList.add(car2);

        // when
        FinalResultDto result = racingGame.playRacingGame(0, carList);

        // then
        assertThat(result.winnerList()).containsExactlyInAnyOrder("car1", "car2");
    }

    @Test
    void 라운드가_없는_경우() {
        // given
        List<Car> carList = List.of(new Car("car1"));
        int roundNumber = 0;

        // when
        FinalResultDto result = racingGame.playRacingGame(roundNumber, carList);

        // then
        assertThat(result.roundResultList()).isEmpty();
        assertThat(result.winnerList()).containsExactly("car1");
    }

    @Test
    void 자동차가_없는_경우_테스트() {
        // given
        List<Car> carList = new ArrayList<>();
        int roundNumber = 1;

        // when
        FinalResultDto result = racingGame.playRacingGame(roundNumber, carList);

        // then
        assertThat(result.winnerList()).isEmpty();
    }
}