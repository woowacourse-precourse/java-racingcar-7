package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차_이름이_중복되면_에러() {
        assertThatThrownBy(() ->
                new Cars("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 무작위_값이_4이상이면_전진한다() {
        // given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(5));
        Cars cars = new Cars("aa");
        // when
        cars.race(testNumberGenerator);
        // then
        assertThat(cars.getCars().get(0).getLocation()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_4보다_작으면_전진하지_않는다() {
        // given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(3));
        Cars cars = new Cars("aa");
        // when
        cars.race(testNumberGenerator);
        // then
        assertThat(cars.getCars().get(0).getLocation()).isEqualTo(0);
    }

    @Test
    void 경주가_끝난_후_가장_멀리_간_사람이_우승자이다() {
        // given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(5, 5, 3, 5, 3, 3, 5, 3, 5));
        Cars cars = new Cars("aa, bb, cc");
        int count = 3;
        // when
        for (int i = 0; i < count; i++) {
            cars.race(testNumberGenerator);
        }
        // then
        assertThat(cars.findWinners()).isEqualTo(List.of(cars.getCars().get(0)));
    }

    @Test
    void 우승자는_여러_명일_수_있다() {
        // given
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(List.of(5, 5, 3, 5, 5, 3, 5, 5, 5));
        Cars cars = new Cars("aa, bb, cc");
        int count = 3;
        // when
        for (int i = 0; i < count; i++) {
            cars.race(testNumberGenerator);
        }
        // then
        assertThat(cars.findWinners()).isEqualTo(List.of(cars.getCars().get(0), cars.getCars().get(1)));
    }
}