package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest extends NsTest {

    @DisplayName("모든 자동차들의 이름과 위치를 출력할 수 있다")
    @Test
    void printCarStatus() {
        // given
        List<Car> givenCars = List.of(
                new Car("a", 5),
                new Car("b", 7),
                new Car("c", 3),
                new Car("d", 0)
        );

        Cars cars = new Cars(givenCars);
        List<String> allStatus = cars.collectAllStatuses();

        // when
        OutputView.printCarStatus(allStatus);

        //then
        assertThat(output())
                .contains(
                        "a : -----",
                        "b : -------",
                        "c : ---",
                        "d :"
                );
    }

    @DisplayName("최중 우승자를 출력할 수 있다.")
    @Test
    void printWinner() {
        // given
        List<Car> givenCars = List.of(
                new Car("a", 5),
                new Car("b", 5),
                new Car("c", 3),
                new Car("d", 0)
        );

        Cars cars = new Cars(givenCars);
        List<Car> winner = cars.findWinner();

        // when
        OutputView.printWinner(winner);

        //then
        assertThat(output())
                .contains("최종 우승자 : a, b");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
