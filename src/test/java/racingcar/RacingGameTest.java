package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    @Test
    @DisplayName("우승자가 한 명일 때 올바르게 반환되는지 테스트한다")
    void 우승자가_한명일_때_올바르게_반환된다() {
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
    @DisplayName("우승자가 여러 명일 때 올바르게 반환되는지 테스트한다")
    void 우승자가_여러명일_때_올바르게_반환된다() {
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

    // Reflection을 사용하여 Car의 position을 설정하는 헬퍼 메서드
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
