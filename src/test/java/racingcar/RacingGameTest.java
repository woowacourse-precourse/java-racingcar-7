package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.DUPLICATE_CAR_NAME_ERROR;

import java.util.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racingcar.domain.*;

public class RacingGameTest {

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        // given
        carNames = Arrays.asList("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("유효한 자동차 이름 입력 - 이름 확인")
    void testValidNames() {
        // given & when
        RacingGame racingGame = new RacingGame(carNames);

        // then
        List<Car> cars = racingGame.getCars();
        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("woni", cars.get(1).getName());
        assertEquals("jun", cars.get(2).getName());
    }

    @DisplayName("중복된 자동차 이름이 입력되었을 때 - IllegalArgumentException 반환")
    @ParameterizedTest
    @MethodSource("provideDuplicateNameInputs")
    void testDuplicateCarNames(List<String> carNames) {
        assertThatThrownBy(() -> new RacingGame(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_CAR_NAME_ERROR);
    }

    static List<List<String>> provideDuplicateNameInputs() {
        return List.of(
                List.of("pobi", "pobi", "woni"),
                List.of("jun", "pobi", "jun", "lee"),
                List.of("pobi", "jun", "jay", "king", "pobi"),
                List.of("gh", "gh"),
                List.of("gh", "pobi", "gh")
        );
    }


    @Test
    @DisplayName("각 자동차가 이동하는지 확인")
    void carsMoveInRacingGame() {
        RacingGame game = new RacingGame(carNames);

        for (Car car : game.getCars()) {
            car.move(5);
        }

        for (Car car : game.getCars()) {
            assertEquals(1, car.getPosition());
        }
    }

    @Test
    @DisplayName("최대 이동 거리")
    void getMaxMoveCount() {
        RacingGame game = new RacingGame(carNames);

        List<Car> cars = game.getCars();
        cars.get(0).move(5);
        cars.get(1).move(7);
        cars.get(2).move(4);

        int maxMoveCount = game.getMaxMoveCount();

        assertEquals(1, maxMoveCount);
    }

    @Test
    @DisplayName("우승자 반환")
    void getWinners() {
        RacingGame game = new RacingGame(carNames);

        List<Car> cars = game.getCars();
        cars.get(0).move(5);
        cars.get(1).move(5);
        cars.get(2).move(3);

        // when
        int maxMoveCount = game.getMaxMoveCount();
        List<String> winners = game.getWinners(maxMoveCount);

        assertEquals(List.of("pobi", "woni"), winners);
    }


}
