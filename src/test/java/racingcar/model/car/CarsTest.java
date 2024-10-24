package racingcar.model.car;

import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 이름들로_자동차를_생성하는_데_성공한다() {
        // given
        String rawCarNames = "car1,car2,car3";
        Cars expected = new Cars(List.of(new Car("car1"), new Car("car2"), new Car("car3")));

        // when
        CarNames carNames = new CarNames(rawCarNames);
        Cars real = new Cars(
                carNames.splitByComma()
                        .stream()
                        .map(Car::new)
                        .toList()
        );

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 경주가_끝나면_라운드의_상태를_나타내는_문자열을_만드는_데_성공한다() {
        // given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2"), new Car("car3")));

        // when
        String real = cars.race();

        // then
        assertThat(real).isInstanceOf(String.class).contains("car1", "car2", "car3", " : ");
    }
}
