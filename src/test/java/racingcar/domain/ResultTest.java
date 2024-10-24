package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void findWinners() {
        //given
        List<Car> allCar = List.of(new Car("boye", 5),
                new Car("Uchae", 5), new Car("sumin", 3));
        Result result = new Result(List.of(new Cars(allCar)));
        List<String> expectWinners = List.of("boye", "Uchae");

        //when
        List<String> winners = result.findWinners();

        //then
        assertThat(winners).isEqualTo(expectWinners);
    }
}