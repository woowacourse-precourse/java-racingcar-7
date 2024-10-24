package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersDeciderTest {

    WinnersDecider winnersDecider = new WinnersDecider();

    @Test
    @DisplayName("동점자가_있다면_우승자가_여려명")
    void run_동점자가_있다면_우승자가_여려명() {
        // given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );

        // when
        List<Car> winners = winnersDecider.run(cars);

        // then
        Assertions.assertThat(winners.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("동점자가_없으면_우승자가_한명")
    void run_동점자가_없으면_우승자가_한명() {
        // given
        List<Car> cars = List.of(new Car("pobi"));

        // when
        List<Car> winners = winnersDecider.run(cars);

        // then
        Assertions.assertThat(winners.size()).isEqualTo(1);
    }

}