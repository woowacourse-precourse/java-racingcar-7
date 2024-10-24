package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.MovementCondition;

class GameManagerTest {

    private static final int RANDOM_START_NUMBER_FOR_MOVE_FORWARD = 0;
    private static final int RANDOM_END_NUMBER_FOR_MOVE_FORWARD = 9;

    @DisplayName("게임 메니저는 주어진 이름에 대해 자동차를 생성할 수 있다.")
    @ParameterizedTest
    @MethodSource("nameSequenceAndNames")
    void generateRacerByGivenNames(String nameSequence, List<String> names) {
        GameManager gameManager = GameManager.from(nameSequence);
        List<String> generatedRacerNames = gameManager.getRacers().stream()
                .map(Car::getName)
                .toList();

        assertThat(generatedRacerNames).isEqualTo(names);
    }

    @DisplayName("게임 메니저는 전진을 결정할 무작위 수를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void generateRandomNumberForMoveForward(int tries) {
        GameManager gameManager = GameManager.from("pobi");
        for (int i = 0; i < tries; ++i) {
            int generatedRandomNumber = gameManager.generateRandomNumberForMoveForward();
            assertThat(
                    RANDOM_START_NUMBER_FOR_MOVE_FORWARD <= generatedRandomNumber &&
                            generatedRandomNumber <= RANDOM_END_NUMBER_FOR_MOVE_FORWARD
            ).isEqualTo(true);
        }
    }

    @DisplayName("게임 메니저는 최종 우승자를 가려낼 수 있다.")
    @ParameterizedTest
    @MethodSource("findWinnersResource")
    void findWinners(String nameSequence, Car moveTarget, List<Car> expectedResult) {
        GameManager gameManager = GameManager.from(nameSequence);
        GameStatus gameStatus = GameStatus.of(1, gameManager.getRacers());
        gameStatus.updateRacerByMovementCondition(moveTarget, MovementCondition.FORWARD);

        assertThat(gameManager.findWinners(gameStatus)).isEqualTo(expectedResult);
    }

    @DisplayName("게임 메니저는 모든 자동차의 전진 상태를 반환할 수 있다.")
    @ParameterizedTest
    @MethodSource("moveForwardStatementResources")
    void getMoveForwardStatements(String nameSequence, List<Car> moveTargets, List<String> expectedStates) {
        GameManager gameManager = GameManager.from(nameSequence);
        GameStatus gameStatus = GameStatus.of(1, gameManager.getRacers());

        for (Car racer : moveTargets) {
            gameStatus.updateRacerByMovementCondition(racer, MovementCondition.FORWARD);
        }

        assertThat(gameManager.getCurrentMovementStates(gameStatus).values().stream().toList()).isEqualTo(
                expectedStates);
    }

    static Stream<Arguments> nameSequenceAndNames() {
        return Stream.of(
                arguments("pobi,woni,jun", Arrays.asList("pobi", "woni", "jun")),
                arguments("  pobi ,   woni,    jun   ", Arrays.asList("pobi", "woni", "jun"))
        );
    }

    static Stream<Arguments> findWinnersResource() {
        return Stream.of(
                arguments("pobi,woni,jun", Car.from("pobi"), Arrays.asList(Car.from("pobi"))),
                arguments("pobi,woni,jun", Car.from("woni"), Arrays.asList(Car.from("woni"))),
                arguments("pobi,woni,jun", Car.from("jun"), Arrays.asList(Car.from("jun")))
        );
    }

    static Stream<Arguments> moveForwardStatementResources() {
        return Stream.of(
                arguments(
                        "pobi,woni,jun",
                        Arrays.asList(Car.from("pobi"), Car.from("woni")),
                        Arrays.asList("-", "-", "")
                ),
                arguments(
                        "pobi,woni,jun",
                        Arrays.asList(Car.from("woni"), Car.from("jun")),
                        Arrays.asList("", "-", "-")
                ),
                arguments(
                        "pobi,woni,jun",
                        Arrays.asList(Car.from("pobi"), Car.from("jun")),
                        Arrays.asList("-", "", "-")
                )
        );
    }
}