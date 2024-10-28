package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

    private static final int ADVANCE_NUMBER = 9;
    private Cars cars;
    private Car pobi;
    private Car woni;
    private Car jun;

    @BeforeEach
    void setUp() {
        String[] carNames = {"pobi", " woni", "jun "};
        cars = Cars.from(carNames);

        pobi = cars.getCars()
                   .get(0);
        woni = cars.getCars()
                   .get(1);
        jun = cars.getCars()
                  .get(2);

        pobi.advance(ADVANCE_NUMBER);  // pobi: 1회 전진
        woni.advance(ADVANCE_NUMBER);  // woni: 1회 전진
        woni.advance(ADVANCE_NUMBER);  // woni: 2회 전진
        jun.advance(ADVANCE_NUMBER);   // jun: 1회 전진
        jun.advance(ADVANCE_NUMBER);   // jun: 2회 전진
    }

    @Test
    void 최대_전진_횟수를_구한다() {
        // when
        int maxAdvanceCount = cars.getMaxAdvanceCount();

        // then
        assertThat(maxAdvanceCount).isEqualTo(2);
    }

    @Test
    void 가장_많이_전진한_우승자를_찾는다() {
        // when
        List<Car> winners = cars.findWinners();

        // then
        assertThat(winners).hasSize(2)
                           .containsExactly(woni, jun);
    }

    @Test
    void 자동차_이름_양옆_공백이_제거된_상태로_저장된다() {
        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(woni.getName()).isEqualTo("woni");
        assertThat(jun.getName()).isEqualTo("jun");
    }

    @Test
    void 중복된_자동차_이름이_있으면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi", "woni", "woni"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_2개_미만이면_예외가_발생한다() {
        // given
        String[] carNames = {"pobi"};

        // when, then
        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
