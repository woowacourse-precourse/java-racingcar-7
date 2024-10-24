package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MovementCondition;

class GameStatusTest {

    private List<Car> tempCars;

    @BeforeEach
    void initialize() {
        tempCars = new ArrayList<>();
        tempCars.add(Car.from("pobi"));
        tempCars.add(Car.from("woni"));
        tempCars.add(Car.from("jun"));
    }

    @DisplayName("시도할 횟수는 양의 정수이어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1,4", "0,5"})
    void isAttemptsPositiveNumber(int invalidNumber, int validNumber) {
        assertAll(
                () -> {
                    assertThatThrownBy(() -> GameStatus.of(invalidNumber, tempCars))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ErrorMessage.ATTEMPTS_SIGN_POSITIVE.getMessage());
                },
                () -> assertDoesNotThrow(() -> GameStatus.of(validNumber, tempCars))
        );
    }

    @DisplayName("시도한 횟수를 늘리고 게임이 끝났는지 판단할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 1000})
    void attemptAndCheckIsEnd(int attempts) {
        GameStatus gameStatus = GameStatus.of(attempts, tempCars);

        assertThat(gameStatus.isEnd()).isEqualTo(false);

        for (int i = 0; i < attempts; ++i) {
            gameStatus.attempt();
        }

        assertThat(gameStatus.isEnd()).isEqualTo(true);
    }

    @DisplayName("각 자동차의 이동 상태를 관리할 수 있다.")
    @ParameterizedTest
    @MethodSource("carToMoveForwardAndResult")
    void manageEachCarMovements(Car racer, List<Integer> result) {
        GameStatus gameStatus = GameStatus.of(1, tempCars);
        gameStatus.updateRacerByMovementCondition(racer, MovementCondition.FORWARD);

        assertThat(
                gameStatus.getRacersMovement().values().stream()
                        .toList()
        ).isEqualTo(result);
    }

    static Stream<Arguments> carToMoveForwardAndResult() {
        return Stream.of(
                arguments(Car.from("pobi"), Arrays.asList(1, 0, 0)),
                arguments(Car.from("woni"), Arrays.asList(0, 1, 0)),
                arguments(Car.from("jun"), Arrays.asList(0, 0, 1))
        );
    }
}