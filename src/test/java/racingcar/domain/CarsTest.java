package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @Test
    void 자동차가_최소_경주_대수_이하일_때_예외_발생() {
        assertThatThrownBy(() -> Cars.from(List.of(Car.from("우테코"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_중복된_경우에_예외_발생() {
        assertThatThrownBy(() -> Cars.from(List.of(Car.from("우테코"), Car.from("우테코"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 랜덤_숫자가_0에서_3까지_일때_모든_자동차의_이동_상황_테스트(int number) {
        Cars cars = Cars.from(List.of(Car.from("우테코"), Car.from("프리코스")));
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveEachCar();
                    cars.getCars().forEach(car -> {
                                        assertThat(car.getPosition()).isEqualTo(0);
                                        assertThat(car.getMoveStatus()).isEqualTo("");
                                    });
                },
                number
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 랜덤_숫자가_4이상_일때_모든_자동차의_이동_상황_테스트(int number) {
        Cars cars = Cars.from(List.of(Car.from("우테코"), Car.from("프리코스")));
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveEachCar();
                    cars.getCars().forEach(car -> {
                        assertThat(car.getPosition()).isEqualTo(1);
                        assertThat(car.getMoveStatus()).isEqualTo("-");
                    });
                },
                number
        );
    }
}
