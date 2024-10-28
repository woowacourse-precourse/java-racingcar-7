package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    void 기능_테스트_우승자_한명() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        RacingGame game = new RacingGame(carNames, 5);

        Car car1 = game.getCars().get(0);
        Car car2 = game.getCars().get(1);
        Car car3 = game.getCars().get(2);

        setCarPosition(car1, 3);
        setCarPosition(car2, 5);
        setCarPosition(car3, 2);

        List<String> winners = game.getWinners();
        assertThat(winners).containsExactly("car2");
    }

    @Test
    void 기능_테스트_우승자_여러명() {
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        RacingGame game = new RacingGame(carNames, 5);

        Car car1 = game.getCars().get(0);
        Car car2 = game.getCars().get(1);
        Car car3 = game.getCars().get(2);

        setCarPosition(car1, 5);
        setCarPosition(car2, 5);
        setCarPosition(car3, 3);

        List<String> winners = game.getWinners();
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2");
    }

    private void setCarPosition(Car car, int position) {
        try {
            java.lang.reflect.Field field = Car.class.getDeclaredField("position");
            field.setAccessible(true);
            field.setInt(car, position);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
