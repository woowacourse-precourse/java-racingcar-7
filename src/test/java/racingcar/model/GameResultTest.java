package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("우승자가 한명인 경우 우승자를 반환한다.")
    void getFinalWinnerForDisplay_One() {
        List<Car> cars = createCars(1, 2);
        GameResult gameResult = GameResult.of(cars);

        String result = gameResult.getFinalWinnerForDisplay();

        assertThat(result).isEqualTo("mogi");
    }

    @Test
    @DisplayName("우승자가 여려명인 경우 우승자들를 반환한다.")
    void getFinalWinnerForDisplay_many() {
        List<Car> cars = createCars(2, 2);
        GameResult gameResult = GameResult.of(cars);

        String result = gameResult.getFinalWinnerForDisplay();

        assertThat(result).isEqualTo("pobi,mogi");
    }

    @Test
    @DisplayName("실행 결과를 반환한다.")
    void testToString() {
        List<Car> cars = createCars(2, 2);
        GameResult gameResult = GameResult.of(cars);

        String result = gameResult.toString();

        assertThat(result).isEqualTo("pobi : --\nmogi : --\n");
    }

    private static List<Car> createCars(int forward, int forward1) {
        return List.of(
                Car.of("pobi", forward),
                Car.of("mogi", forward1)
        );
    }

}