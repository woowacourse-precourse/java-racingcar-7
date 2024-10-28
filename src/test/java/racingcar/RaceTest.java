package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.infrastructure.exception.ErrorCode.*;
import static racingcar.domain.race.constants.RaceCriterion.MOVING_FORWARD;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

@DisplayName("Race 클래스 테스트")
public class RaceTest {

    private final Acceleration acceleration = new FixedAcceleration(MOVING_FORWARD.getCriterion());

    @Test
    void 문자열을_파싱하여_자동차_객체를_생성한다() {
        // given
        String input = "pobi,woni,javai";

        // when
        Race race = Race.of(input, acceleration);

        // then
        assertThat(race.getCars().size()).isEqualTo(3);
    }

    @Test
    void 입력된_순서대로_자동차_객체를_생성한다() {
        // given
        String input = "pobi,woni,javai";

        // when
        Race race = Race.of(input, acceleration);

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

        assertThatThrownBy(() -> Race.of(exceededLengthName, acceleration))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(CAR_NAME_LENGTH_EXCEEDED.getMessage());
    }

    @Test
    void 매_턴_마다_조건에_따라_자동차가_전진다() {
        // given
        String input = "pobi,woni,javai";
        Race race = Race.of(input, acceleration);

        // when
        race.lap();

        // then
        List<Car> cars = race.getCars();
        assertThat(cars.get(0).getPosition()).isEqualTo(1);
        assertThat(cars.get(1).getPosition()).isEqualTo(1);
        assertThat(cars.get(2).getPosition()).isEqualTo(1);
    }

    @Test
    void 경기_결과를_출력한다() {
        // given
        String input = "pobi,jack";
        Race race = Race.of(input, acceleration);

        // when
        race.lap();

        // then
        assertThat(race.getRoundResult()).isEqualTo(
            "pobi : -\njack : -"
        );
    }
}
