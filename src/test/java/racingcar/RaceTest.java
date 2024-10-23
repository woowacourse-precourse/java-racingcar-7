package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.ErrorCode.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.race.Race;

@DisplayName("Race 클래스 테스트")
public class RaceTest {

    @Test
    void 문자열을_파싱하여_자동차_객체를_생성한다() {
        // given
        String input = "pobi,woni,javai";

        // when
        Race race = Race.from(input);

        // then
        assertThat(race.getCars().size()).isEqualTo(3);
    }

    @Test
    void 입력된_순서대로_자동차_객체를_생성한다() {
        // given
        String input = "pobi,woni,javai";

        // when
        Race race = Race.from(input);

        // then
        List<Car> cars = race.getCars();
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("javai");
    }

    @Test
    void 유효하지_않은_이름이_파싱된다면_예외를_발생한다() {
        // given
        String exceededLengthName = "pobi,woni,javai,123456789012345678901";

        assertThatThrownBy(() -> Race.from(exceededLengthName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_EXCEEDED.getMessage());
    }

    @Test
    void 매_턴_마다_조건에_따라_자동차가_전진한다() {
        // given
        String input = "pobi,woni,javai";
        Race race = Race.from(input);

        // when
        race.lap();

        // then
        List<Car> cars = race.getCars();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }
}
