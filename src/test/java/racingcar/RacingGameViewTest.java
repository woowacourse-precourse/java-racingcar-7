package racingcar;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameViewTest {
    @Test
    void 자동차_이동거리_출력_형식_테스트() {
        RacingGameView view = new RacingGameView();
        Car car = new Car("pobi");
        car.move(4);  // 한 칸 전진

        String result = view.generateCarStatus(car);

        assertThat(result).isEqualTo("pobi : -");
    }

    @Test
    void 우승자_출력_형식_테스트() {
        RacingGameView view = new RacingGameView();
        List<String> winners = Arrays.asList("pobi", "woni");

        String result = view.generateWinnersMessage(winners);

        assertThat(result).isEqualTo("최종 우승자 : pobi, woni");
    }
}