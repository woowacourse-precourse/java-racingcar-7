package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCarProcessTest {
    @DisplayName("랜덤한 숫자가 0에서 3 사이의 숫자라면 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 전진_하지않는_경우_테스트(int number) {
        String name = "pobi";
        GameCar gameCar = new GameCar(name);
        gameCar.move(number);
        assertThat(gameCar.getForwardMarksSize()).isEqualTo(1);
    }

    @DisplayName("랜덤한 숫자가 4에서 9 사이의 숫자라면 자동차는 1만큼 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_하는경우_테스트(int number) {
        String name = "java";
        GameCar gameCar = new GameCar(name);
        gameCar.move(number);
        assertThat(gameCar.getForwardMarksSize()).isEqualTo(2);
    }
}