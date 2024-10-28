package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.RacingCarGameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("pobi", "woni"));
    }

    @Test
    void 자동차_이름이_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("pobi", "pobi")))
                .isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("자동차 이름은 중복이 되지 않아야 합니다.");
    }

    @Test
    void 자동차가_두대_이상_이어야한다() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("pobi"))).
                isInstanceOf(RacingCarGameException.class)
                .hasMessageContaining("경주에 참가하는 자동차는 2개 이상이어야 합니다.");
    }

    @Test
    void 모든_자동차가_이동한다() {
        NumberGenerator numberGenerator = () -> 4;

        cars.moveAll(numberGenerator);
        List<Car> raceCars = cars.getCars();

        assertThat(raceCars.get(0).getPosition().position()).isEqualTo(1);
        assertThat(raceCars.get(1).getPosition().position()).isEqualTo(1);
    }

    @Test
    void 자동차가_4_이상인_난수를_발생시키면_이동하고_그렇지_않으면_이동하지_않는다() {
        NumberGenerator numberGenerator1 = () -> 4;
        NumberGenerator numberGenerator2 = () -> 3;

        cars.getCars().get(0).move(numberGenerator1);
        cars.getCars().get(1).move(numberGenerator2);

        List<Car> raceCars = cars.getCars();
        assertThat(raceCars.get(0).getPosition().position()).isEqualTo(1);
        assertThat(raceCars.get(1).getPosition().position()).isEqualTo(0);
    }
}