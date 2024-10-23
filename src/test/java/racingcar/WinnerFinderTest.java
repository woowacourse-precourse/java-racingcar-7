package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SearchWinnerTest {
    @Test
    void 우승자_찾기() {
        List<Car> carList = Arrays.asList(new Car("pobi", 1), new Car("woni", 2), new Car("jun", 3));
        Cars cars = new Cars(carList);

        SearchWinner searchWinner = SearchWinner.getInstance();
        assertThat(searchWinner.)
    }
}
