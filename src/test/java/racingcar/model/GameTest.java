package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.CarSnapshot;
import racingcar.model.car.Cars;
import racingcar.model.game.Game;
import racingcar.model.game.NumberPicker;
import racingcar.model.game.PositionBasedReferee;
import racingcar.model.game.RandomNumberPicker;
import racingcar.model.game.TotalRounds;

public class GameTest {

    private static final int MOVEMENT_CRITERIA = 4;

    private Game game;
    private String[] names;
    private Cars cars;
    private TotalRounds totalRounds;
    private int totalRoundCount;

    @BeforeEach
    void setUp() {
        totalRoundCount = 3;
        totalRounds = new TotalRounds(totalRoundCount);
        names = new String[]{"pobi", "woni", "jun"};
        cars = new Cars(names);
        game = new Game(cars, totalRounds, new RandomNumberPicker(), new PositionBasedReferee());
    }

    @Test
    @DisplayName("출전하는 자동차가 2대보다 적은 경우에는 예외를 던진다.")
    void throwExceptionWhenNumberOfCarsIsFewerThanMinimumNumberOfCars() {
        // given
        String[] nameOfCars = new String[]{"pobi"};
        Cars invalidNumberOfCars = new Cars(nameOfCars);

        // when & then
        assertThatThrownBy(
                () -> new Game(invalidNumberOfCars, totalRounds, new RandomNumberPicker(), new PositionBasedReferee()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 2대 이상 출전해야 합니다.");
    }

    @Test
    @DisplayName("전체 라운드 진행 후 더 이상 남은 라운드가 없음을 확인한다")
    void returnFalseWhenAllRoundsAreCompleted() {
        // when
        for (int i = 0; i < totalRoundCount; i++) {
            game.playNextRound();
        }

        // then
        assertThat(game.hasMoreRounds()).isFalse();
    }

    @Test
    @DisplayName("전체 라운드 진행되지 않은 상태에서 남은 라운드가 있음을 확인한다")
    void returnTrueWhenRoundsAreNotCompleted() {
        // when
        for (int i = 0; i < totalRoundCount - 1; i++) {
            game.playNextRound();
        }

        // then
        assertThat(game.hasMoreRounds()).isTrue();
    }

    @Test
    @DisplayName("뽑힌 숫자가 이동 기준 이상일 때 자동차가 움직인다.")
    void shouldMoveCarsWhenNumberExceedsMoveCriteria() {

        // given
        NumberPicker fixedNumberPicker = new NumberPicker() {
            @Override
            public int pickNumberInRange(int startInclusive, int endInclusive) {
                return MOVEMENT_CRITERIA;
            }
        };

        Game game = new Game(cars, totalRounds, fixedNumberPicker, new PositionBasedReferee());
        List<CarSnapshot> expectedResult = List.of(
                new CarSnapshot(names[0], 1, 1),
                new CarSnapshot(names[1], 1, 1),
                new CarSnapshot(names[2], 1, 1)
        );

        // when
        game.playNextRound();
        List<CarSnapshot> carSnapshots = game.getCarSnapshots();

        // then
        assertThat(carSnapshots).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("뽑힌 숫자가 이동 기준보다 작을 때 자동차가 움직이지 않는다.")
    void shouldNotMoveCarsWhenNumberIsLessThanMoveCriteria() {

        // given
        NumberPicker fixedNumberPicker = new NumberPicker() {
            @Override
            public int pickNumberInRange(int startInclusive, int endInclusive) {
                return MOVEMENT_CRITERIA - 1;
            }
        };

        Game game = new Game(cars, totalRounds, fixedNumberPicker, new PositionBasedReferee());
        List<CarSnapshot> expectedResult = List.of(
                new CarSnapshot(names[0], 0, 1),
                new CarSnapshot(names[1], 0, 1),
                new CarSnapshot(names[2], 0, 1)
        );

        // when
        game.playNextRound();
        List<CarSnapshot> carSnapshots = game.getCarSnapshots();

        // then
        assertThat(carSnapshots).isEqualTo(expectedResult);
    }
}
