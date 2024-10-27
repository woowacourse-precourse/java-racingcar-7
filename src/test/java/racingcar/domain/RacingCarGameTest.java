package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarGameTest {

    static Stream<Arguments> provideCarNamesAndMoves() {
        return Stream.of(
                Arguments.of(List.of("pobi", "wonni", "jun"), List.of(2, 4, 6)),
                Arguments.of(List.of("a", "b", "c"), List.of(1, 1, 1)),
                Arguments.of(List.of("carA", "carB", "carC", "carD", "carE"), List.of(5, 5, 3, 9, 1))
        );
    }

    @DisplayName("generatedMove 메서드 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void Number_Generated_Should_be_In_Between_Zero_To_Nine(int totalCars) {
        RacingCarGame racingCarGame = new RacingCarGame();
        List<Integer> move = racingCarGame.generateMove(totalCars);
        for (Integer Generatednumber : move) {
            assertDoesNotThrow(() -> {
                if (!(Generatednumber >= 0 && Generatednumber <= 9)) {
                    throw new IllegalArgumentException("잘못된 숫자가 생성됐습니다.");
                }
            });
        }
    }

    @DisplayName("moveEachCars 메서드 테스트")
    @ParameterizedTest
    @MethodSource("provideCarNamesAndMoves")
    void Car_Only_Move_If_Generated_Number_Four_Or_Bigger_Than_Four(List<String> carNames, List<Integer> moves) {
        RacingCarGame racingCarGame = new RacingCarGame(carNames);
        racingCarGame.moveEachCars(moves);
        List<Car> cars = RacingCarsGroup.getCars();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (moves.get(i) >= 4) {
                assertEquals("-", car.getFinalPosition(car.getPosition()), "생성된 전진값이 4이상일 경우 전진해야 한다.");
            }
            if (moves.get(i) < 4) {
                assertNotEquals("-", car.getFinalPosition(car.getPosition()), "생성된 전진값이 4미만일 경우 전진하지 않아야 한다.");
            }
        }
    }

}
